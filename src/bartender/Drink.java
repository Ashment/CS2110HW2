package bartender;

import javax.swing.ImageIcon;

public class Drink {
	public String name;
	public String[] ingredients;
	public String ing;
	DrinksAndIngredients m;
	
	public ImageIcon icon;
	
	public Drink(String n, String ings, DrinksAndIngredients di, String iconLocation){
		name = n;
		m = di;
		ing = ings;
		ingredients = m.ConvertIngredients(ing);
		icon = new ImageIcon(iconLocation);
		
		//Debug: print the drink and its ingredients
		System.out.println("Drink " + name + ": " + IngredientPrint());
	}
	
	public String IngredientPrint(){
		//Returns ingredients as a string
		String s = "";
		for(int i=0; i<ingredients.length; i++){
			s += ingredients[i];
			if(i<(ingredients.length-1)){
				s += ", ";
			}
		}
		s += (", CODE = " + ing);
		
		return s;
	}
}
