package com.tests;

import com.base.Gene;
import com.base.Organism;

public class BinaryOrgo extends Organism {
	private static int GENOME_SIZE = 2;
	
	public BinaryOrgo(boolean random) {
		super(GENOME_SIZE, random);
	}
	
	public BinaryOrgo(Gene[] transferDNA) {
		super(transferDNA);
	}

	@Override
	public Organism mate(Organism other) {
		if(other instanceof BinaryOrgo) {
			Gene[] childGenome = new Gene[GENOME_SIZE];
			for(int i = 0; i < GENOME_SIZE; i++) {
				childGenome[i] = this.dna[i].mate(((BinaryOrgo) other).dna[i]);
			}
			return new BinaryOrgo(childGenome);
		} else return null;
	}

}
