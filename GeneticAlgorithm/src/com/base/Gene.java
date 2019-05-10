/**
 * Models a single gene with a 
 * 		fitness level between 0 and 1
 */
package com.base;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Gene {
	boolean[] gene;
	//Percentage 1 - 100
	private static int MUTATION_RATE = 1; 
	private static int GENE_LENGTH = 10;
	private static Random gen = new Random(); 
	private static DecimalFormat fmt = new DecimalFormat("0.00"); 
	
	public Gene(boolean random) {
		gene = new boolean[GENE_LENGTH];
		if(random)
			for(int i = 0; i < GENE_LENGTH; i++)
				gene[i] = gen.nextBoolean();
		else
			for(int i = 0; i < GENE_LENGTH; i++)
				gene[i] = false;
	}
	
	public Gene(boolean[] genome) {
		this.gene = genome;
	}
	
	public double fitness() {
		int sum = 0; //number of trues
		for(boolean bit : gene) {
			if(bit)
				sum++;
		}
		return (double) sum / GENE_LENGTH;
	}
	
	public void mutate() {
		for(int i = 0; i < GENE_LENGTH; i++) {
			if(gen.nextInt(100) < MUTATION_RATE) {
				gene[i] = !gene[i];
			}
		}
	}
	
	public Gene mate(Gene other) {
		int index = gen.nextInt(GENE_LENGTH);
		boolean[] newGene = new boolean[GENE_LENGTH];
		for(int i = 0; i < index; i++) {
			newGene[i] = this.gene[i];
		}
		for(int i = index + 1; i < GENE_LENGTH; i++) {
			newGene[i] = other.gene[i];
		}
		return new Gene(newGene);
	}
	
	public String toString() {
//		return "" + fmt.format(fitness());
		return dnaToString();
	}
	
	private String dnaToString() {
		String out = "[";
		for(boolean bit : gene)
			out += bit ? 1 : 0;
		return out + "]";
	}
}
