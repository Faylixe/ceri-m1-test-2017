#!/usr/bin/python

""" """

import logging

from argparse import ArgumentParser
from os.path import join
from requests import get
from subprocess import call
from tempfile import mkdtemp


_CODACY = 'https://api.codacy.com/2.0/%s/ceri-m1-test-2017'
_CODECOV = 'https://codecov.io/api/gh/%s/ceri-m1-test-2017'
_CIRCLECI = 'https://circleci.com/api/v1.1/project/github/%s/ceri-m1-test-2017'
_GITHUB = 'https://github.com/%s/ceri-m1-test-2017'
_GITHUB_FORK = 'https://api.github.com/repos/Faylixe/ceri-m1-test-2017/forks?per_page=100'

_KEYS = (
    'pom.xml',
    '.circleci/config.yml',
    'codacy setup',
    'codecov setup',
    'circleci setup',
    'unit tests',
    'implementation',
    'coverage rate',
    'codacy grade'
)

def _json_path_valid(data, path):
    """ Indicates if the given path if valid for given json data. """
    current = data
    for node in path.split('.'):
        if node not in current:
            return False
        current = current[node]
    return True


class SynthesisBuilder(object):
    """ Class responsible for creating student synthesis. """

    def __init__(self, username, codacy_token):
        """ Default constructor. """
        self._username = username
        self._codacy_token = codacy_token
        self._workspace = mkdtemp()
        self._synthesis = {}
        for key in _KEYS:
            self._synthesis[key] = 0

    def _get_json(self, url_pattern):
        """ Retrieves JSON response from given URL pattern. """
        url = _CODACY % self._username
        response = get(url, headers={'api_token': self._codacy_token})
        if response.status_code != 200:
            raise IOError('Unable to access to endpoint %s' % url)
        return response.json()

    def _evaluate_pom(self):
        """ Evaluate POM. """
        url = _GITHUB % self._username
        logging.info('Cloning repository %s' % url)
        if call(['git', 'clone', url], cwd=self._workspace) != 0:
            raise IOError('Cannot clone git repository %s' % url)
        logging.info('Validate POM.xml')
        if call(['mvn', 'validate'], cwd=join(self._workspace, 'ceri-m1-test-2017')) == 0:
            self._synthesis['pom.xml'] = 0.5

    def _evaluate_codacy(self):
        """ Evaluate codacy configuration and grade. """
        data = self._get_json(_CODACY)
        if _json_path_valid(data, 'commit.commit.grade'):
            grade = data['commit']['commit']['grade']
            self._synthesis['codacy setup'] = 0.5
            if grade == 'A':
                self._synthesis['codacy grade'] = 2
            elif grade == 'B':
                self._synthesis['codacy grade'] = 1

    def _evaluate_codecov(self):
        """ Evaluates codecov integration. """
        data = self._get_json(_CODECOV)
        if 'error' not in data and _json_path_valid('commit.totals.c'):
            coverage = data['commit']['totals']['c']
            self._synthesis['codecov setup'] = 0.5
            if coverage > 85:
                self._synthesis['coverage rate'] = 2
            elif coverage > 69:
                self._synthesis['coverage rate'] = 1

    def _evaluate_circleci(self):
        """ Evaluation CircleCI integration. """
        data = self._get_json(_CIRCLECI)
        if 'message' in data and data['message'] == 'Project not found':
            logging.warn('CircleCI not configured for project %s/ceri-m1-test-2017' % self._username)
        else:
            self._synthesis['circleci setup'] = 0.5
            status = data[0]['status']
            if status == "success":
                self._synthesis['circleci setup'] = 1

    def build(self):
        """ Build synthesis for target user. """
        logging.info('Starting %s evaluation' % self._username)
        self._evaluate_pom()
        self._evaluate_circleci()
        self._evaluate_codecov()
        self._evaluate_codacy()
        output = []
        for key in _KEYS:
            output.append(self._synthesis[key])
        return ','.join(output)


def _get_forks():
    """ Retrieves all forks from original repository. """
    response = get(_GITHUB_FORK)
    if response.status_code != 200:
        logging.error('Unable to check forks (status code : %s)' % response.status_code)
        return
    usernames = []
    for fork in response.json():
        usernames.append(fork['owner']['login'])
    return usernames

if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument('--token')
    parser.add_argument('--output')
    args = parser.parse_args()
    students = _get_forks()
    with open(args.output, 'w') as stream:
        if students is not None:
            print(','.join(_KEYS))
            for student in students:
                builder = SynthesisBuilder(student, args.token)
                stream.write(builder.build()))
