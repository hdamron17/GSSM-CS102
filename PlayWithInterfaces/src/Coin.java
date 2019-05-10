/**
 * Coin class has name and value and can be compared to
 * other Coins
 * @author HDamron17
 * //Coin.java
 */
public class Coin implements Comparable<Coin> {
	private String name;
	private int value;
	
	/**
	 * Constructs Coin with name and value
	 * @param name Name of Coin
	 * @param value Monetary value of Coin
	 */
	public Coin(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Compares to other Coins
	 * @param other
	 * @return
	 */
	public int compareTo(Coin other) {
		return this.value - other.value;
	}
	
	/**
	 * Gets the name
	 * @return Name of Coin
	 */
	public String name() {
		return name;
	}
	
	/**
	 * Gets the value of the Coin
	 * @return 
	 */
}
