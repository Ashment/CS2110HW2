package bartender;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BartendingPanel extends JPanel{
	GridBagConstraints gc;
	
	public ImageIcon cdrink;
	public ImageIcon cMixer;
	JLabel drinkLabel, drinkName, mixerLabel;
	
	public BartendingPanel(ImageIcon mixer, ImageIcon drink){
		setPreferredSize(new Dimension(105, 300));
		setBackground(Color.GRAY);
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		
		drinkLabel = new JLabel(drink);
		drinkName = new JLabel("  ");
		mixerLabel = new JLabel(mixer);
		
		gc.insets = new Insets(20, 0, 15, 0);
		gc.gridx = 0; gc.gridy = 0; gc.weighty = 5;
		add(drinkLabel, gc);
		gc.insets = new Insets(0, 0, 25, 0);
		gc.gridy = 1; gc.weighty = 1;
		add(drinkName, gc);
		gc.insets = new Insets(15, 0, 15, 0);
		gc.gridy = 2; gc.weighty = 80;
		add(mixerLabel, gc);
	}
	
	public void SetMixerIcon(ImageIcon i){
		mixerLabel.setIcon(i);
	}
	
	public void UpdateDrink(Drink d){
		if(d != null){
			drinkLabel.setIcon(d.icon);
			drinkName.setText(d.name);
		}else{
			drinkLabel.setIcon(DrinksAndIngredients.badDrink.icon);
			drinkName.setText("  ");
		}
	}
}
