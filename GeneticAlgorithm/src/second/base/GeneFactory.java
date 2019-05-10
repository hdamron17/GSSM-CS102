package second.base;

public interface GeneFactory<E extends Gene> {
	public E[] makePopulation(int size, boolean random);
	public E[] makeEmptyPopulation(int size);
}
