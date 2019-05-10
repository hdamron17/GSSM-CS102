/**
 * 
 */
package com.base;

import java.util.Arrays;
import java.util.Random;

public abstract class Organism {
	protected Gene[] dna;
	protected Random gen = new Random();
	
	public Organism(int genomeSize, boolean random) {
		dna = new Gene[genomeSize];
		for(int i = 0; i < dna.length; i++) {
			dna[i] = new Gene(random);
		}
	}
	
	public Organism(Gene[] transferDNA) {
		dna = transferDNA;
	} 
	
	public void mutate() {
		for(Gene gene : dna) {
			gene.mutate();
		}
	}
	
	public double fitness() {
		double sum = 0;
		for(Gene gene : dna) {
			sum += gene.fitness();
		}
//System.out.println("Organism " + Arrays.toString(dna) + " fit = " + sum / dna.length);
		return sum / dna.length;
	}
	
	public String toString() {
		return Arrays.toString(dna);
	}
	
	//Must mate with organism of the same species
	public abstract Organism mate(Organism other);
}
