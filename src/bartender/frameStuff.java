package bartender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class frameStuff extends JFrame {
	
	JPanel customersPanel;
	JPanel[] cPanels = new JPanel[5];
	
	public frameStuff(String title, Main d){
		super(title);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		
		addKeyListener(new KeyInput(d));
		
		customersPanel = new JPanel();
		customersPanel.setSize(new Dimension(560, 150));
		customersPanel.setBackground(Color.RED);
		customersPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		for(int i=0; i<cPanels.length; i++){
			gc.gridx = i;
			cPanels[i] = new JPanel();
			cPanels[i].setLayout(new FlowLayout());
			cPanels[i].setSize(60, 100);
			cPanels[i].setBackground(Color.BLUE);
			System.out.print(i);
		}
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		customersPanel.add(cPanels[0], gc);
		gc.gridx = 1;
		customersPanel.add(cPanels[1], gc);
		gc.gridx = 2;
		customersPanel.add(cPanels[2], gc);
		gc.gridx = 3;
		customersPanel.add(cPanels[3], gc);
		gc.gridx = 4;
		customersPanel.add(cPanels[4], gc);
		
		add(customersPanel, BorderLayout.PAGE_START);
	}
}
