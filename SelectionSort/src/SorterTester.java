/**
 * Utilizes the SorterGraph component to display the graph of sorting efficiency
 * @author Hunter Damron
 * //SorterTester.java
 * //Honor Code: I did not lie, cheat, or steal
 */
import javax.swing.JFrame;

public class SorterTester {
	public static void main(String[] args) {		
		JFrame frame = new JFrame();
		SorterGraph grapher = new SorterGraph();
		frame.setSize(1200, 600);
		frame.setResizable(false);
		frame.setTitle("Big O Sorting Efficiency Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(grapher);
		frame.setVisible(true);
	}
}
