package p16_4;
/**
 * Failed GUI
 */
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RosterGUI {
	public static void main(String[] args) {
		JFrame frame;
		JScrollPane pane;
		JTable table;
		JButton add, remove, change;
		JPanel panel;
		String[] columns = new String[] {"Name", "Grade", "Letter Grade"};
		
		Roster group = new Roster("Comp Sci 101");
		group.add("Johnny", 89);
		group.add("Will", 99);
				
		table = new JTable(group.getRoster(), columns);

		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		
		pane = new JScrollPane(table);
		GridBagConstraints paneConstraints = new GridBagConstraints();
		paneConstraints.gridwidth = GridBagConstraints.REMAINDER;
		paneConstraints.fill = GridBagConstraints.BOTH;
		paneConstraints.ipady = 200;
		panel.add(pane, paneConstraints);
		
		add = new JButton("Add student");
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new JPanel();
				panel.add(new JLabel("Student name: "));
				JTextField nameField = new JTextField();
				nameField.setColumns(10);
				panel.add(nameField);
				panel.add(new JLabel(" Grade: "));
				JFormattedTextField gradeField = new JFormattedTextField(NumberFormat.getNumberInstance());
				gradeField.setColumns(10);
				panel.add(gradeField);
				
				JOptionPane.showOptionDialog(null, panel, "Change Student Grade", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				String gradeText = gradeField.getSelectedText();
				if(gradeText != "") 
					group.add(nameField.getText(), Double.parseDouble(gradeText));
				else
					group.add(nameField.getText());
				//TODO update roster and table
			}});
		GridBagConstraints addConstraints = new GridBagConstraints();
		addConstraints.gridy = GridBagConstraints.RELATIVE; 
		addConstraints.fill = GridBagConstraints.BOTH;
		panel.add(add, addConstraints);
		
		remove = new JButton("Remove student");
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] names = new String[table.getRowCount()];
				for(int i = 0; i < names.length; i++) {
					names[i] = (String) table.getValueAt(i, 0);
				}				
				String choice = (String) JOptionPane.showInputDialog(null, "Choose a student to Remove", 
						"Remove Student", 
						JOptionPane.QUESTION_MESSAGE, null, names, null);
				group.remove(choice);
				//TODO update table
			}});
		GridBagConstraints removeConstraints = new GridBagConstraints();
		removeConstraints.gridx = GridBagConstraints.RELATIVE; 
		removeConstraints.fill = GridBagConstraints.BOTH;
		panel.add(remove, removeConstraints);
		
		change = new JButton("Change student grade");
		change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new JPanel();
				String[] names = new String[table.getRowCount()];
				for(int i = 0; i < names.length; i++) {
					names[i] = (String) table.getValueAt(i, 0);
				}
				JComboBox<String> choices = new JComboBox<String>(names);
				panel.add(choices);
				panel.add(new JLabel("Grade: "));
				JFormattedTextField field = new JFormattedTextField(NumberFormat.getNumberInstance());
				field.setColumns(10);
				panel.add(field);
				
				JOptionPane.showOptionDialog(null, panel, "Change Student Grade", JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				String gradeText = field.getText();
				if(gradeText != "")
					group.changeGrade((String) choices.getSelectedItem(), Double.parseDouble(gradeText));
				//TODO update table
			}});
		GridBagConstraints changeConstraints = new GridBagConstraints();
		changeConstraints.gridx = GridBagConstraints.RELATIVE;
		changeConstraints.fill = GridBagConstraints.BOTH;
		panel.add(change, changeConstraints);
		
		frame.add(panel);
		frame.setSize(600, 400);
		frame.setTitle("Student Roster for " + group.name());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
