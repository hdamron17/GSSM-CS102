
public abstract class Sorter {
	protected int[] array;
	
	public Sorter(int[] array) {
		this.array = array;
	}
	
	public abstract int[] sort();
}
