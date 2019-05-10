/**
 * Decodes a user selected .encr file and saves it.
 * @author Hunter Damron
 * //Decoder.java
 * //Honor Code: I did not lie, cheat, or steal.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Decoder {
	public static void main(String[] args) throws IOException {
		JFileChooser chooser = new JFileChooser();
		BufferedReader input;
		PrintWriter output;
		String[][] data;
		String inputLine = "";
		int row, col;
		boolean cont = true, saveCont = true, endOfFile = false;
		
		chooser.setFileFilter(new FileNameExtensionFilter("Exncrypted Text File (*.encr)", "encr"));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File (*.txt)", "txt"));
		label1: while(cont && chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				input = new BufferedReader(new FileReader(chooser.getSelectedFile()));
			} catch(IOException e) {
				e.printStackTrace();
				cont = JOptionPane.showConfirmDialog(null, 
						"Oops. File could not be openned. Would you like to try again?",
						"Missing File", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
				continue label1;
			}
			try {
				row = Integer.parseInt(input.readLine());
				col = Integer.parseInt(input.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
				cont = JOptionPane.showConfirmDialog(null, "This file has incorrect "
						+ "formatting so it cannot be processed. Would you like to select "
						+ "a different one?", "Improper Formatting", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
				input.close();
				continue label1;
			}
			data = new String[row][col];
			for(int index = 0; index < row * col && !endOfFile; index++) {
				try {
					inputLine = input.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					data[index % row][index / row] = "";
					continue;
				}
				if(inputLine != null) {
					data[index % row][index / row] = inputLine;
				} else {
					endOfFile = true;
					continue;
				}
			}
			if(JOptionPane.showConfirmDialog(null, "Your message has been successfully "
					+ "decoded. Would You like to save it?", "Decode successful", 
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				label2: while(saveCont && chooser.showSaveDialog(null) 
						== JFileChooser.APPROVE_OPTION) {
					try {
						output = new PrintWriter(new FileWriter(chooser.getSelectedFile()));
					} catch (IOException e) {
						saveCont = JOptionPane.showConfirmDialog(null, "Invalid save "
								+ "location. Would you like to try again? (Warning: if you "
								+ "select no, all data will be lost.)", "Invalid Save Location", 
								JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
						continue label2;
					}
					for(String[] colNum : data) {
						for(String val : colNum) {
							if(val != null) {
								output.print(val + " ");
							}
						}
					}
					output.close();
					saveCont = false;
				}
			}
			cont = JOptionPane.showConfirmDialog(null, "Would you like to decode another message?", 
					"Process Complete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
			input.close();
		}
	}
}

/**
 * Output output.txt from data1.encr
 * 
 * To gain the most knowledge in the class be curious ask questions start thinking right away on 
 * assignments take responsibility for your own education 
 */