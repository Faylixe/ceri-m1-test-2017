package fr.univavignon.rodeo.api;

/**
 * Manages game states.
 * 
 * @author fv
 */
public interface IGameStateProvider {

	/**
	 * Saves the given <tt>gameState</tt>.
	 * 
	 * @param gameState The game state to save.
	 */
	void save(IGameState gameState);

	/**
	 * Retrieves (eventually load lazilly) the game state.
	 * 
	 * @param name Name of the game state to retrieve.
	 * @return Associated game state if any, or a new one otherwise.
	 * @throws IllegalArgumentException If the given <tt>name</tt> is <tt>null</tt>
	 */
	IGameState get(String name) throws IllegalArgumentException;

}
