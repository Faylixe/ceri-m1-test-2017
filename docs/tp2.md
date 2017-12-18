# TP2 : Continous integration and quality assesment

## Configure CircleCI

[CircleCI](https://circleci.com/) provide free continuous integration service based on Docker container.
First go to [CircleCI index](https://circleci.com/) and sign up using your GitHub account.

![signup](https://github.com/Faylixe/ceri-m1-test-2017/blob/master/docs/images/cisignup.png?raw=true)

Then use the dashboard to connect your repository (``Projects > Add project``), which will trigger CI for any repository
update event automatically.

### Create .circleci/config.yml

In order to define what your CI will do for your repository you need to write a configuration file in your repository.
This file should be located at ``.circleci/config.yml`` and contains at least a job on *master* branch using
an *oracle-jdk8* docker image, and which executes build and test goal on maven.

You can use [official documentation](https://circleci.com/docs/2.0/) which contains configuration specs, as sample
configuration file as well.

## Configure Covecov

## Configure Codacy
