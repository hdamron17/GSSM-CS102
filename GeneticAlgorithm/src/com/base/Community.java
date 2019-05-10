/**
 * 
 */
package com.base;

import java.text.DecimalFormat;

public abstract class Community<E extends Organism> {
	private E[] population;
	private int generation;
	private boolean eliteSelection;
	private static DecimalFormat fmt = new DecimalFormat("0.00");
	
	public Community(int popCount, boolean elite, boolean random) {
		population = spawnCommunity(popCount, random);
		eliteSelection = elite;
	}
	
	public Community(E[] population, boolean elite) {
		this.population = population;
		eliteSelection = elite;
		generation = 0;
	}
	
	//Mates organsims for a new population of the same size
	public void newGen() {
		generation++;
		double[] probs = new double[population.length];
		probs[0] = population[0].fitness();
		population[0].mutate();
		for(int i = 1; i < population.length; i++) {
			probs[i] = probs[i - 1] + population[i].fitness();
			population[i].mutate();
		}
		double probRange = probs[probs.length - 1];
		Organism[] newGen = new Organism[population.length];
		newGen[0] = population[fittestIndex()];
		for(int i = eliteSelection ? 1 : 0; i < population.length; i++) {
			double mateProb = Math.random() * probRange;
			Organism parent = null;
			findMate: for(int j = 0; j < probs.length; j++) {
				if(mateProb < probs[j]) {
					parent = population[j];
					break findMate;
				} else parent = population[0];
			}
			probRange = Math.random() * probRange;
			findMate: for(int j = 0; j < probs.length; j++) {
				if(mateProb < probs[j]) {
					newGen[i] = parent.mate(population[j]);
					break findMate;
				} else newGen[i] = parent.mate(population[0]);
			}
		}
		population = (E[]) newGen;
	}
	
	//returns the best fitness level
	public double fittest() {
		double fittest = 0;
		for(E orgo : population) {
			double orgoFit = orgo.fitness();
			if(orgoFit > fittest)
				fittest = orgoFit;
		}
		return fittest;
	}
	
	private int fittestIndex() {
		double fittest = 0;
		int index = 0;
		for(int i = 0; i < population.length; i++) {
			double orgoFit = population[i].fitness();
			if(orgoFit > fittest) {
				fittest = orgoFit;
				index = i;
			}
		}
		return index;
	}
	
	public double avgFit() {
		double sum = 0;
		for(E orgo : population) {
			sum += orgo.fitness();
		}
		return sum / population.length;
	}
	
	public String toString() {
		String msg = "{gen " + generation + "; \t fittest = " + fmt.format(fittest()) + " \tavg fit = " + fmt.format(avgFit());
		for(E orgo : population) {
			msg += " " + orgo;
		}
		return msg + "}";
	}
	
	//spawns a new communtiy of organisms of the same species
	public abstract E[] spawnCommunity(int popCount, boolean random);
}
