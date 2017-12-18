package fr.univavignon.rodeo.api;

/**
 * Animal definition.
 * 
 * @author fv
 */
public interface IAnimal extends INamedObject {

	/**
	 * Getter for the associated species XP.
	 * 
	 * @return The amount of XP given when riding it.
	 */
	int getXP();

	/**
	 * Indicates if this animal is a secret one.
	 * 
	 * @return <tt>true</tt> if this animal is a secret one, <tt>false</tt> otherwise.
	 */
	boolean isSecret();

	/**
	 * Indicates if this animal is an endangered one..
	 * 
	 * @return <tt>true</tt> if this animal is an endangered one, <tt>false</tt> otherwise.
	 */
	boolean isEndangered();

	/**
	 * Indicates if this animal is a boss.
	 * 
	 * @return <tt>true</tt> if this animal is a boss, <tt>false</tt> otherwise.
	 */
	boolean isBoss();

}
