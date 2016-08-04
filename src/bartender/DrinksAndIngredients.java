package bartender;

import java.util.Hashtable;

public class DrinksAndIngredients {
	Hashtable<String, String> ingredients = new Hashtable<String, String>();
	Drink[] drinks;
	
	public DrinksAndIngredients(){
		//Initialize ingredients
		ingredients.put("Q", "Gin");
		ingredients.put("W", "Vodka");
		ingredients.put("E", "Whiskey");
		ingredients.put("R", "Vermouth");
		ingredients.put("T", "Tequila");
		ingredients.put("Y", "Beer");
		ingredients.put("U", "Rum");
		ingredients.put("A", "Sugar");
		ingredients.put("S", "Lime");
		ingredients.put("D", "Tonic Water");
		ingredients.put("F", "Juice");
		
		//Initialize Drinks
		drinks = new Drink[11];
		drinks[0] = new Drink("Gin Tonic", "ADQ", this);
		drinks[1] = new Drink("Martini", "QRSW", this);
		drinks[2] = new Drink("Long Island", "QTUW", this);
		drinks[3] = new Drink("Manhatten", "ERS", this);
		drinks[4] = new Drink("Risky", "DEW", this);
		drinks[5] = new Drink("Bacardi", "ASU", this);
		drinks[6] = new Drink("Ithaca Storm", "FUWY", this);
		drinks[7] = new Drink("Foxhound", "RSTY", this);
		drinks[8] = new Drink("Vodka Tonic", "DSW", this);
		drinks[9] = new Drink("Djinn", "EQQT", this);
		drinks[10] = new Drink("Moscow Snow", "FRWW", this);
	}
	
	public String GetIngredient(String key){
		String t = ingredients.get(key);
		if(t == ""){
			t = "None";
		}
		return t;
	}
	
	public String[] ConvertIngredients(String keys){
		String[] ingredients;
		char[] ingChars = keys.toCharArray();
		ingredients = new String[ingChars.length];
		for(int i=0; i<ingChars.length; i++){
			String temp = GetIngredient(Character.toString(ingChars[i]));
			ingredients[i] = temp;
		}
		
		return  ingredients;
	}
}
