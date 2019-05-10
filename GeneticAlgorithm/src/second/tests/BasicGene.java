package second.tests;

//import java.text.DecimalFormat;
import java.util.Random;

import second.base.*;

public class BasicGene implements Gene {
	private boolean[] genome;

	private static final int GENE_LENGTH = 10,
			MUTATION_RATE = 3;
//	private static DecimalFormat fmt = new DecimalFormat("0.00");
	private static Random gen = new Random();
	
	public static class Factory implements GeneFactory<BasicGene> {
		public BasicGene[] makePopulation(int size, boolean random) {
			BasicGene[] population = new BasicGene[size];
			for(int i = 0; i < size; i++)
				population[i] = new BasicGene(random);
			return population;
		}
		
		public BasicGene[] makeEmptyPopulation(int size) {
			BasicGene[] population = new BasicGene[size];
			return population;
		}
	}
	
	public BasicGene(boolean random) {
		this.genome = initGenome(random);
	}
	
	public BasicGene(boolean[] genome) {
		if(genome.length == GENE_LENGTH)
			this.genome = genome;
		else this.genome = initGenome(true);
	}
	
	private boolean[] initGenome(boolean random) {
		boolean[] newGenome = new boolean[GENE_LENGTH];
		if(random)
			for(int i = 0; i < GENE_LENGTH; i++) 
				newGenome[i] = gen.nextBoolean();
		else for(int i = 0; i < GENE_LENGTH; i++)
				newGenome[i] = false;
		return newGenome;
	}

	@Override
	public void mutate() {
		for(int i = 0; i < GENE_LENGTH; i++) {
			if(gen.nextInt(100) < MUTATION_RATE) {
				genome[i] = !genome[i];
			}
		}
	}

	@Override
	public double fitness() {
		int sum = 0; //number of trues
		for(boolean bit : genome) {
			if(bit) sum++;
		}
		return (double) sum / GENE_LENGTH;		
	}
	
	@Override
	public Gene mate(Gene other) {
		int index = gen.nextInt(GENE_LENGTH);
		boolean[] newGene = new boolean[GENE_LENGTH];
		for(int i = 0; i < index; i++) {
			newGene[i] = this.genome[i];
		}
		for(int i = index + 1; i < GENE_LENGTH; i++) {
			newGene[i] = ((BasicGene) other).genome[i];
		}
		return new BasicGene(newGene);
	}
	
	public String toString() {
		String out = "[";
		for(boolean bit : genome)
			out += bit ? 1 : 0;
		return out + "]";
	}
}
