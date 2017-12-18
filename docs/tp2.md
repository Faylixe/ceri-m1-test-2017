# TP2 : Continous integration and quality assesment

## Configure CircleCI

[CircleCI](https://circleci.com/) provide free continuous integration service based on Docker container.
First go to [CircleCI index](https://circleci.com/) and sign up using your GitHub account.

Then use the dashboard to connect your repository (``Projects > Add project``), which will trigger CI for any repository
update event automatically.

### Create .circleci/config.yml

In order to define what your CI will do for your project you need to write a configuration file in your repository.
This file should be located at ``.circleci/config.yml`` and contains at least one job on *master* branch using
an *oracle-jdk8* docker image, and which executes build and test goal on maven.

You can use [official documentation](https://circleci.com/docs/2.0/) which contains configuration specs, as sample
configuration file as well.

## Configure Covecov and Codacy

As for [CircleCI](https://circleci.com/) you will now connect to your repository following services :

- [Codecov](https://codecov.io) which will manage test coverage report
- [Codacy](https://www.codacy.com/) which will manage project code quality

You may need to add tasks into your ``pom.xml`` and ``.circleci/config.yml`` in order to submit information
to those services through continuous integration.

## Development workflow

Once every services are configured, you need to ensure that the following development workflow is operational :

- Push on your repository trigger CI
- CI compile your project and run unit tests
- CI generate report and send them to [Codecov](https://codecov.io) and [Codacy](https://www.codacy.com/)

