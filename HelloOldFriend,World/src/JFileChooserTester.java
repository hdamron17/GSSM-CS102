import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserTester {
	public static void main(String[] args) throws IOException {
		JFileChooser chooser = new JFileChooser(new File("ExternFiles"));
		chooser.setDialogTitle("Choose wisely");
		chooser.setMultiSelectionEnabled(false);
		chooser.setFileFilter(new FileNameExtensionFilter("Hunter's File Extension", "hunter"));
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		FileInputStream input = new FileInputStream(file);
		Scanner reader = new Scanner(input);
		String message = "";
		while(reader.hasNextLine()) {
			message = reader.nextLine() + "\n";
		}
		JOptionPane.showMessageDialog(null, message);
		input.close(); reader.close();
	}
}