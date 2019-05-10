package second.base;

public interface Gene {
	public abstract void mutate();
	public abstract double fitness();
	public abstract Gene mate(Gene other);
}
