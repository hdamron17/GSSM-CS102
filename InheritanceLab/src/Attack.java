/**
 * Provides attack types for Pokemon (not yet necessary for basic version)
 * @author Hunter Damron
 * //Attack.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public enum Attack {
	NORMAL("Normal"), FIRE("Fire"), WATER("Water"), GRASS("Grass"), 
	ELECTRIC("Electric"), ICE("Ice"), FIGHTING("Fighting"), BUG("Bug"), 
	PSYCHIC("Psychic"), GHOST("Ghost"), GROUND("Ground");
	
	public String name;
	
	/**
	 * Constructor associates enumeration with name
	 * @param name
	 */
	private Attack(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the attack type's name
	 * @return Returns name
	 */
	public String toString() {
		return name;
	}
}
