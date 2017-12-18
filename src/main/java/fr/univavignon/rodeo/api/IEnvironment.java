package fr.univavignon.rodeo.api;

import java.util.List;

/**
 * Interface for a target environment in Rodeo Stampede
 * (such as Savannah). An environment provides available
 * species.
 * 
 * @author fv
 */
public interface IEnvironment extends INamedObject {

	/**
	 * Getter for the number of area available in this
	 * environment.
	 * 
	 * @return Number of area available.
	 */
	int getAreas();

	/**
	 * Getter for the species available in this
	 * environment.
	 * 
	 * @return List of species available.
	 */
	List<ISpecie> getSpecies();

}
