/**
 * Tests the polymorphism of classes which extend Pokemon
 * @author Hunter Damron
 * //PokemonPolymorphismTest.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import java.util.Arrays;

public class PokemonPolymorphismTest {
	public static void main(String[] args) {
		Pokemon[] poke = new Pokemon[] {new Seviper("Fang"), 
				new Charmeleon("Supa Hot Fire")};
		int success;
		System.out.println("Expected Output: [Seviper named Fang "
				+ "[Health = 140, Type = Bug], Charmeleon named Supa "
				+ "Hot Fire [Health = 100, Type = Fire]]");
		System.out.println("Actual Ouput:    " + Arrays.deepToString(poke) + "\n");
		
		success = poke[0].attack(poke[1]);
		System.out.println("Fang's turn to attack:\n----------------------");
		if(success == Pokemon.STATUS_SUCCESS) {
			System.out.println("Expected Output: \tCharmeleon named Supa Hot "
					+ "Fire [Health = 90, Type = Fire, Status = Poisoned]");
			System.out.println("Actual Output:   \t" + poke[1]);

			System.out.println("*Damage from poison is then inflicted");
			poke[1].inflictDamage();
			System.out.println("Expected Output: \tCharmeleon named Supa Hot "
					+ "Fire [Health = 85, Type = Fire, Status = Poisoned]");
			System.out.println("Actual Output:   \t" + poke[1] + "\n");
		} else if(success == Pokemon.ATTACK_SUCCESS) {
			System.out.println("Expected Output: \tCharmeleon named Super Hot "
					+ "Fire [Health = 90, Type = Fire]");
			System.out.println("Actual Output:   \t" + poke[1] + "\n");
			poke[1].inflictDamage();
		} else {
			System.out.println("No change. Attack missed\n");
		}
		
		System.out.println("Supa Hot Fire's turn to attack:"
				+ "\n--------------------------------");
		success = poke[1].attack(poke[0]);
		if(success == Pokemon.STATUS_SUCCESS) {
			System.out.println("Expected Output: \tSeviper named Fang [Health = 120, "
					+ "Type = Bug, Status = Burnt]");
			System.out.println("Actual Output:   \t" + poke[0]);

			System.out.println("*Damage from burn is then inflicted");
			poke[0].inflictDamage();
			System.out.println("Expected Output: \tSeviper named Fang [Health = 110, "
					+ "Type = Bug, Status = Burnt]");
			System.out.println("Actual Output:   \t" + poke[0]);
		} else if(success == Pokemon.ATTACK_SUCCESS) {
			System.out.println("Expected Output: \tSeviper named Fang [Health = 120, "
					+ "Type = Bug]");
			System.out.println("Actual Output:   \t" + poke[0] + "\n");
			poke[1].inflictDamage();
		} else {
			System.out.println("No change. Attack missed\n");
		}
	}
}
