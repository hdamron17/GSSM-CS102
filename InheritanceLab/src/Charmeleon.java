/**
 * Extends Pokemon - Fire type Pokemon capable of causing burns
 * @author Hunter Damron
 * //Charmeleon.java
 * //Honor Code: I did not lie, cheat, or steal
 */
public class Charmeleon extends Pokemon {
	public Charmeleon(String name) {
		this.name = name;
		type = Attack.FIRE;
		status = Damage.HEALTHY;
		health = 100;
		species = "Charmeleon";		
	}
	
	/**
	 * Overrides Pokemon attack method (does 20 damage and can burn)
	 * @return Returns value representing success of attack
	 */
	public int attack(Pokemon opposition) {
		if(status.canAttack && opposition.hurt(20, 85)) {
			if(opposition.inflictStatus(Damage.BURN, 2, 3))		
				return Pokemon.STATUS_SUCCESS;
			else return Pokemon.ATTACK_SUCCESS;
		} else return Pokemon.ATTACK_MISS;
	}
}
