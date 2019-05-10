package second.base;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Population<E extends Gene> {
	private E[] group;
	private GeneFactory<E> factory;
	private int generation;
	private boolean elite;
	
	private static int NUM_BRACKETS = 10;
	
	private static DecimalFormat fmt = new DecimalFormat("0.00");
	private static Random gen = new Random();
	
	public Population(int size, boolean random, boolean elite, GeneFactory<E> factory) {
		this.factory = factory;
		this.elite = elite;
		generation = 0;
		group = factory.makePopulation(size, random);
	}
	
	public Population(E[] group, boolean elite, GeneFactory<E> factory) {
		this.group = group;
		this.factory = factory;
		generation = 0;
	}
	
	/**
	 * Creates the next generation of Genes
	 * @param true = tournament selection, 
	 * 		false = roulette wheel
	 */
	public void newGen(boolean mode) {
		generation++;
		group = mode ? tournamentSelect() : rouletteWheel();
	}
	
	private E[] rouletteWheel() {
System.out.println("Entering rouletteWheel() {");
		E[] newGen = factory.makeEmptyPopulation(group.length);
		
		double[] probs = new double[group.length];
		group[0].mutate();
		probs[0] = group[0].fitness();
		for(int i = 1; i < group.length; i++) {
			group[i].mutate();
			probs[i] = probs[i - 1] + group[i].fitness();
		}
		double probRange = probs[probs.length - 1];
		if(probRange == 0)
			return group;
		
System.out.print("probs\t");
for(double prob : probs) {
	System.out.print("[" + fmt.format(prob) + "] ");
}
System.out.println();
System.out.print("group\t");
for(Gene gene : group) {
	System.out.print("[" + fmt.format(gene.fitness()) + "] ");
}
System.out.println();
		
		if(elite)
			newGen[0] = group[fittestIndex()];
		for(int i = elite ? 1 : 0; i < group.length; i++) {
			E parent = null, child = null;
			double selection = gen.nextDouble() * probRange;
			select: for(int j = 0; j < group.length; j++) {
				if(selection < probs[j]) {
					parent = group[j];
System.out.print(parent + "(" + j + ") + ");
					break select;
				}
			}
			selection = gen.nextDouble() * probRange;
			select: for(int j = 0; j < group.length; j++) {
				if(selection <= probs[j]) {
					child = (E) parent.mate(group[j]);
System.out.println(group[j] + " (" + j + ") = " + child);
					break select;
				}
			}
			newGen[i] = child;
		}
System.out.print("newGen\t");
for(Gene gene : newGen) {
	System.out.print("[" + fmt.format(gene.fitness()) + "] ");
}
System.out.println("\n}\n");
		return newGen;
	}
	
	private E[] tournamentSelect() {
		E[] newGen = factory.makeEmptyPopulation(group.length);
		int size = group.length / NUM_BRACKETS + 1;
		for(int i = 0; i < group.length; i++) 
			group[i].mutate();
		for(int i = 0; i < group.length; i++) {
			newGen[i] = innerTournamentSelect(size);
		}
		return newGen;
	}
	
	private E innerTournamentSelect(int size) {
		E[] bracket = factory.makeEmptyPopulation(size);
System.err.println("innerTournamentSelect() is incomplete");
		//TODO
		return null;
	}
	
	public double fittest() {
		double fittest = 0;
		for(E orgo : group) {
			double orgoFit = orgo.fitness();
			if(orgoFit > fittest)
				fittest = orgoFit;
		}
		return fittest;
	}
	
	private int fittestIndex() {
		double fittest = 0;
		int index = 0;
		for(int i = 0; i < group.length; i++) {
			double orgoFit = group[i].fitness();
			if(orgoFit > fittest) {
				fittest = orgoFit;
				index = i;
			}
		}
		return index;
	}
	
	public double avgFit() {
		double sum = 0;
		for(E orgo : group) {
			sum += orgo.fitness();
		}
		return sum / group.length;
	}
	
	public String toString() {
		String msg = "{gen " + generation + "; \t fittest = " 
				+ fmt.format(fittest()) + " \tavg fit = " + fmt.format(avgFit());
		for(E orgo : group) {
			msg += " " + orgo;
		}
		return msg + "}";
	}
}
