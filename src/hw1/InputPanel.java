package hw1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel{

	public JTextField inputArea;
	JLabel inputLabel;
	GridBagConstraints gc;
	
	MainProgram main;
	
	public InputPanel(MainProgram m){
		//Initialize
		main = m;
		setPreferredSize(new Dimension(500, 80));
		setBackground(Color.DARK_GRAY);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 1;
		
		//Components
		inputArea = new JTextField(15);
		Dimension size = inputArea.getPreferredSize();
		size.width = 200;
		inputArea.setPreferredSize(size);
		inputArea.setForeground(Color.BLUE);
		inputLabel = new JLabel("Input Numbers or File Name: ");
		inputLabel.setForeground(Color.WHITE);
		
		//Adding Components
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(inputArea, gc);
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		add(inputLabel, gc);
	}
	
}
