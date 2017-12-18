# TP3 : Unit testing

Now that our project is configured properly and CI is operational we can start writing unit tests for the existing API.
We want a maximum coverage score for our unit tests, which will be written for all existing *interfaces*, and will be
reused with concrete implementation later to ensure that there is no regression during development.

First create a new directory ``src/test/java`` in which test classes will be located under ``fr.univavignon.rodeo``
package. Ensure ``pom.xml`` is up to date and can handle this new test source directory. We are expecting 6 test cases :

- **IAnimalTest**
- **IEnvironmentTest**
- **IEnvironmentProviderTest**
- **IGameStateTest**
- **IGameStateProviderTest**
- **ISpecieTest**

For each test case, external dependencies should use mock instance through [Mockito](http://site.mockito.org/) library.
And for associated interface test, target instance should also be created as mock instance.

You have to ensure that the code coverage and quality does not regress through development using
previously configured platform.

## Rodeo Stampede

This project is based on the mobile game [Rodeo Stampede](http://rodeo-stampede.wikia.com/wiki/Rodeo_Stampedia)
which consists in catching differents variation of animal specie to create an amazing zoo which will make you rich.

You can progress into various **IEnvironment** which are divided into area. For each environment you have **ISpecie**
that you can catch, and for each specie you can have various **IAnimal**. **IEnvironment** can be retrieve using
an **IEnvironmentProvider** which is in charge of retrieving game metadata through the web
(for example, from official game [wiki](http://rodeo-stampede.wikia.com/wiki/Rodeo_Stampedia))

Finally the player progression can be controlled by the **IGameState**, and such object are created through
**IGameStateProvider** instance. 

The API javadoc can be found [here](http://faylixe.fr/ceri-m1-test-2017/javadoc) and is summerized by following class diagram :

![api](https://github.com/Faylixe/ceri-m1-test-2017/blob/master/docs/images/api.png?raw=true)