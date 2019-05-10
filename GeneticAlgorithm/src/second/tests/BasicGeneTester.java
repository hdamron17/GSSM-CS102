package second.tests;
import second.base.*;

public class BasicGeneTester {
	public static void main(String[] args) {
		Population<BasicGene> pop = 
				new Population<BasicGene>(10, false, false, new BasicGene.Factory());
		for(int i = 0; i < 100; i++) {
//			System.out.println(pop);
			pop.newGen(false);
		}
		System.out.println(pop);
		
		BasicGene parent1 = new BasicGene(true), parent2 = new BasicGene(true);
System.out.println(parent1 + " + " + parent2 + " = " + parent1.mate(parent2));
System.out.print(parent1 + " mutates to ");
parent1.mutate();
System.out.println(parent1);
	}
}
