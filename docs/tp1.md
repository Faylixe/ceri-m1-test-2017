# TP1 : Setup the environment

## Fork the project

First go into the [repository](https://github.com/Faylixe/ceri-m1-test-2017)
(and guess what, you already are) and fork it into your account by clicking on
the **fork** button :

![fork](https://github.com/Faylixe/ceri-m1-test-2017/blob/master/docs/images/fork.png?raw=true)

After few minutes, you should have a copy of the project in your own repository, that you can clone into
your machine by using the following command :

```bash
git clone https://github.com/your_username/ceri-m1-test-2017
```

Be careful and don't forget to replace **your_username** by your real username in the URL.

## Create POM.xml

The repository you have forked only contains the project API in a java package.
In order to make your project useable we will write a ``pom.xml`` file which will
turn your project into a valid [Maven](https://maven.apache.org) project.

The written ``pom.xml`` should contains at least :

- Project metadata (name, author, url).
- Project version using [semantic versionning](https://semver.org/).
- Lifecycle definition, such as build and test.
- Dependency list with at least **JUnit**.

To ensure your file is valid and your project ready, you can use the following command :

```bash
mvn validate
```

## Import project into Eclipse

Finally we will now import the project into Eclipse as a maven project. Use the import tool ``File > Import``,
select ``existing maven project`` and finalize the import.

![eclipse](https://github.com/Faylixe/ceri-m1-test-2017/blob/master/docs/images/eclipse.png?raw=true)
