package fr.univavignon.rodeo.api;

import java.util.List;

/**
 * Specie definition.
 * 
 * @author fv
 */
public interface ISpecie extends INamedObject {

	/**
	 * Getter for the target area in which this
	 * specie can be found.
	 * 
	 * @return The area in which this specie can be found from.
	 */
	int getArea();

	/**
	 * Associated animals getter.
	 * 
	 * @return List of available animal for this specie.
	 */
	List<IAnimal> getAnimals();

}
