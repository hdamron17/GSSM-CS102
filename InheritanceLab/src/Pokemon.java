/**
 * Abstract Pokemon class has type, status, and health and 
 * 		can fight other Pokemon
 * @author Hunter Damron
 * //Pokemon.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.Random;

public abstract class Pokemon {
	protected String name, species;
	protected Attack type;
	protected Damage status;
	protected int health, statusCounter;
	private Random gen = new Random();
	public static final int ATTACK_MISS = 0, 
			ATTACK_SUCCESS = 1, STATUS_SUCCESS = 2;
	
	/**
	 * Attack method implemented in subclass
	 * @param opposition Pokemon recieving the attack
	 * @return Returns int reflecting success
	 */
	public abstract int attack(Pokemon opposition);
	
	/**
	 * Hurts the Pokemon
	 * @param damage Damage inflicted if successful
	 * @param accuracy Accuracy of attack (of 100)
	 * @return Returns success
	 */
	public boolean hurt(int damage, int accuracy) {
		if(gen.nextInt(100) < accuracy) {
			health -= damage;
			return true;
		} else return false;
	}
	
	/**
	 * Inflicts the pokemon with a status
	 * @param infliction Status to be inflicted on pokemon
	 * @param strength Length of time that the pokemon is inflicted
	 * @param chance Change that the poison will be successful (of 10)
	 * @return Returns success
	 */
	public boolean inflictStatus(Damage infliction, int strength, int chance) {
		if(gen.nextInt(10) < chance) {
			status = infliction;
			statusCounter = strength;
			return true;
		} else return false;
	}
	
	/**
	 * Tests if the pokemon is dead
	 * @return Returns true if the pokemon is dead
	 */
	public boolean isDead() {
		if(health <= 0) {
			status = Damage.DEAD;
			return true;
		} else return false;
	}
	
	/**
	 * Inflicts damage from pending afflictions and 
	 * 		counts down the time remaining on the affliction
	 */
	public void inflictDamage() {
		health -= status.damage;
		statusCounter--;
		if(statusCounter == 0) 
			status = Damage.HEALTHY;
	}
	
	/**
	 * Gets the name of the pokemon
	 * @return Returns the name of the pokemon
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the status afflicting the pokemon
	 * @return Returns the pokemon's status
	 */
	public Damage getStatus() {
		return status;
	}
	
	/**
	 * Overrides Object.toString() method to print the pokemon's 
	 * 		name, species, health, type, and status (if applicable)
	 * @return Returns the pokemon represented as a string
	 */
	public String toString() {
		String message = "" + species + " named " + name + " [Health = " + health + ", Type = " + type;
		if(status != Damage.HEALTHY)
			message += ", Status = " + status;
		message += "]";
		return message;
	}
}
