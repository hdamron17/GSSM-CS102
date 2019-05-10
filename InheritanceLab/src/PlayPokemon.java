import java.util.Arrays;

public class PlayPokemon {
	public static void main(String[] args) {
		Pokemon[] pokemon = {new Seviper("Shadow Fang"), new Charmeleon("Blaze")};
		System.out.println(pokemon[0] + "\n" + pokemon[1] + "\n");
		
		for(int i = 0; !pokemon[0].isDead() && !pokemon[1].isDead(); i++) {
			System.out.println(Arrays.deepToString(pokemon));
			pokemon[i % pokemon.length].attack(pokemon[(i + 1) % pokemon.length]);
			System.out.println(Arrays.deepToString(pokemon));
			for(Pokemon poke : pokemon) {
				poke.inflictDamage();
			}
			System.out.println(Arrays.deepToString(pokemon) + "\n");
		}
		findVictor: {
		for(Pokemon poke : pokemon) {
			if(!poke.isDead()) {
				System.out.println(poke.name + " is victorious!");
				break findVictor;
			}
		}
		System.out.println("There is no victor. All pokemon are dead.");
		}
	}
}