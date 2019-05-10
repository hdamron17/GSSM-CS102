/**
 * Provides damage from from special statuses that can affect pokemon
 * @author Hunter Damron
 * //Damage.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public enum Damage {
	HEALTHY(0, true, "Healthy"), BURN(10, true, "Burnt"), POISON(5, true, "Poisoned"), 
	CONFUSION(0, false, "Confused"), SLEEP(0, false, "Asleep"), FREEZE(0, false, "Frozen"), 
	PARALYSIS(0, false, "Paralyzed"), DEAD(0, false, "Dead");
	
	public int damage;
	public boolean canAttack;
	public String name;
	
	/**
	 * Constructor associates enumeration with its default variables
	 * @param damage Damage done per turn by status
	 * @param canAttack Determines if the pokemon can attack
	 * @param name Name of affliction
	 */
	private Damage(int damage, boolean canAttack, String name) {
		this.damage = damage;
		this.canAttack = canAttack;
		this.name = name;
	}
	
	/**
	 * Gets the status type's name
	 * @return Returns name
	 */
	public String toString() {
		return name;
	}
}
