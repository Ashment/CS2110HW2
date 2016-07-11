package hw1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ButtonPanel extends JPanel{
	int width = 500, height = 80;
	JButton button1, button2, button3, button4;
	GridBagConstraints gc;
	MainProgram main;
	
	FileParser fileParser;
	
	public ButtonPanel(MainProgram m){
		main = m;
		fileParser = new FileParser();
		
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(width, height));
		
		TitledBorder titBorder = new TitledBorder("Choose Analysis Source Type");
		titBorder.setTitleJustification(TitledBorder.CENTER);
		titBorder.setTitleColor(Color.WHITE);
		setBorder(titBorder);
		
		setLayout(new GridBagLayout());
		button1 = new JButton("Analyze String");
		button2 = new JButton("Analyze File");
		
		InitInterface();
		UpdateInteractionBehavior();
	}
	
	public void InitInterface(){
		gc = new GridBagConstraints();
		gc.weightx = 1;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		add(button1, gc);
		gc.gridx = 1;
		add(button2, gc);
	}
	
	public void UpdateInteractionBehavior(){
		//Behavior
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				main.AnalyzeNumbers(main.mainGUI.inputPanel.inputArea.getText());
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					main.AnalyzeFile(fileParser.parseFile(main.mainGUI.inputPanel.inputArea.getText()));
				} catch (Exception e1) {
					main.mainGUI.outputPanel.outputArea.setText("\n" + e1.toString());
				}
			}
		});
	}
}
