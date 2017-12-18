package fr.univavignon.rodeo.api;

/**
 * This interface represents a game state.
 * Aims to be instantiated by an {@link IGameStateProvider}.
 * 
 * @author fv
 */
public interface IGameState extends INamedObject {

	/**
	 * Unlock a new area / environment. Ensures that all animals
	 * of the current area are unlocked and that there is a new
	 * area to explore, throwing an IllegalStateException otherwise.
	 * 
	 * @throws IllegalStateException If the area cannot be explored.
	 */
	void exploreArea() throws IllegalStateException;

	/**
	 * Sets the given <tt>animal</tt> as caught.
	 * 
	 * @param animal Animal to caught.
	 * @throws IllegalArgumentException If the given <tt>animal</tt> is <tt>null</tt>.
	 * @throws IllegalStateException If the given <tt>animal</tt> can not be found in current areas.
	 */
	void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException;

	/**
	 * Retrieves the level of the given specie.
	 * 
	 * @param specie Specie to get level for.
	 * @return Current specie level.
	 * @throws IllegalArgumentException If the given <tt>specie</tt> is <tt>null</tt>
	 */
	SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException;

	/**
	 * Computes and returns the game progression percentage.
	 * 
	 * @return The total game progression in percent.
	 */
	int getProgression();

}
