package bartender;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RecipePanel extends JPanel{
	JLabel recipeBook;
	
	public RecipePanel(){
		setPreferredSize(new Dimension(200, 300));
		setBackground(Color.WHITE);
		
		JLabel RECIPE = new JLabel("RECIPES:");
		recipeBook = new JLabel("<html>Bacardi:<br>-Rum<br>-Lime<br>-Sugar<br><br>Djinn:<br>-2x Gin<br>-Whiskey<br>-Tequila<br><br>Foxhound:<br>-Vermouth<br>-Beer<br>-Tequila<br>-Lime<br><br>Gin Tonic:<br>-Gin<br>-Tonic Water<br>-Sugar<br><br>Ithaca Storm:<br>-Rum<br>-Beer<br>-Vodka<br>-Juice<br><br>Long Island:<br>-Gin<br>-Rum<br>-Vodka<br>-Tequila<br><br>Manhattan:<br>-Vermouth<br>-Whiskey<br>-Lime<br><br>Martini:<br>-Vodka<br>-Gin<br>-Vermouth<br>-Lime<br><br>Moscow Snow:<br>-2x Vodka<br>-Vermouth<br>-Juice<br><br>Risky:<br>-Whiskey<br>-Tonic Water<br>-Vodka<br><br>Vodka Tonic:<br>-Vodka<br>-Tonic Water<br>-Lime</html>");
		//recipeBook.setSize(new Dimension(100, 100));
		JScrollPane scroll = new JScrollPane(recipeBook, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setSize(new Dimension(200, 300));
		scroll.setMinimumSize(new Dimension(200, 300));
		scroll.setMaximumSize(new Dimension(200, 300));
		scroll.setPreferredSize(new Dimension(200, 275));
		
		add(RECIPE);
		add(scroll);
	}
}
