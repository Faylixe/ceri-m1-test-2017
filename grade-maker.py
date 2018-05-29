#!/usr/bin/python

""" """

import logging

from os.path import join
from requests import get
from subprocess import call
from tempfile import mkdtemp


_CODACY = 'https://app.codacy.com/project/%s/ceri-m1-test-2017/dashboard'
_CODECOV = 'https://codecov.io/api/gh/%s/ceri-m1-test-2017'
_CIRCLECI = 'https://circleci.com/api/v1.1/project/github/%s/ceri-m1-test-2017'
_GITHUB = 'https://github.com/%s/ceri-m1-test-2017'


class SynthesisBuilder(object):

    def __init__(self, username):
        """ Default constructor. """
        self._username = username
        self._workspace = mkdtemp()
        self._synthesis = {
            'pom.xml': 0,
            '.circleci/config.yml': 0,
            'codacy setup': 0,
            'codecov setup': 0,
            'circleci setup': 0,
            'unit tests': 0,
            'implementation': 0,
            'coverage rate': 0,
            'codacy grade': 0
        }

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
        url = _CODACY % self._username
        grade = None # TODO : Retrieve grade
        self._synthesis['codacy setup'] = 0.5
        if grade == 'A':
            self._synthesis['codacy grade'] = 2
        elif grade == 'B':
            self._synthesis['codacy grade'] = 1

    def _evaluate_codecov(self):
        """ Evaluates codecov integration. """
        url = _CODECOV % self._username
        response = get(url)
        if response.status_code != 200:
            raise IOError('Unable to access to CodeCov endpoint')
        data = response.json()
        # TODO : Check for error.
        coverage = data['coverage']
        self._synthesis['codecov setup'] = 0.5
        if coverage > 85:
            self._synthesis['coverage rate'] = 2
        elif coverage > 69:
            self._synthesis['coverage rate'] = 1

    def _evaluate_circleci(self):
        """ Evaluation CircleCI integration. """
        url = _CIRCLECI % self._username
        response = get(url)
        if response.status_code != 200:
            raise IOError('Unable to access to CircleCI endpoint')
        data = response.json()
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
