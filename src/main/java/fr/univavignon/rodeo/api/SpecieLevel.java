package fr.univavignon.rodeo.api;

/**
 * Enumeration of level available per specie.
 * 
 * @author fv
 */
public enum SpecieLevel {

	/** Novice level. **/
	NOVICE(0),

	/** Wrangler level. **/
	WRANGLER(25),
	
	/** Champion level. **/
	CHAMPION(150),
	
	/** Master level. **/
	MASTER(600)
	
	;

	/** Amount of XP required to reach this level. **/
	private final int requiredXP;

	/**
	 * Default constructor.
	 * 
	 * @param requiredXP Amount of XP required to reach this level.
	 */
	private SpecieLevel(final int requiredXP) {
		this.requiredXP = requiredXP;
	}

	/**
	 * Getter for required level XP.
	 * 
	 * @return Amount of XP required to reach this level.
	 */
	public int getRequiredXP() {
		return requiredXP;
	}

}
