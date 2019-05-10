/**
 * Extends Pokemon - Bug type Pokemon capable of poisoning
 * @author Hunter Damron
 * //Seviper.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public class Seviper extends Pokemon {
	public Seviper(String name) {
		this.name = name;
		type = Attack.BUG;
		status = Damage.HEALTHY;
		health = 140;
		species = "Seviper";
	}
	
	/**
	 * Overrides Pokemon attack method (does 10 damage and can poison)
	 * @return Returns value representing success of attack
	 */
	public int attack(Pokemon opposition) {
		if(status.canAttack && opposition.hurt(10, 95)) {
			if(opposition.inflictStatus(Damage.POISON, 4, 3))		
				return Pokemon.STATUS_SUCCESS;
			else return Pokemon.ATTACK_SUCCESS;
		} else return Pokemon.ATTACK_MISS;
	}
}
