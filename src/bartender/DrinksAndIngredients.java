package bartender;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;

public class DrinksAndIngredients {
	public static Hashtable<String, String> ingredients = new Hashtable<String, String>();
	public static Drink[] drinks;
	public static Drink badDrink;
	
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
		drinks[0] = new Drink("Gin Tonic", "ADQ", this, "Drinks/GinTonic.png");
		drinks[1] = new Drink("Martini", "QRSW", this, "Drinks/Martini.png");
		drinks[2] = new Drink("Long Island", "QTUW", this, "Drinks/LongIsland.png");
		drinks[3] = new Drink("Manhattan", "ERS", this, "Drinks/Manhattan.png");
		drinks[4] = new Drink("Risky", "DEW", this, "Drinks/Risky.png");
		drinks[5] = new Drink("Bacardi", "ASU", this, "Drinks/Bacardi.png");
		drinks[6] = new Drink("Ithaca Storm", "FUWY", this, "Drinks/IthacaStorm.png");
		drinks[7] = new Drink("Foxhound", "RSTY", this, "Drinks/Foxhound.png");
		drinks[8] = new Drink("Vodka Tonic", "DSW", this, "Drinks/VodkaTonic.png");
		drinks[9] = new Drink("Djinn", "EQQT", this, "Drinks/Djinn.png");
		drinks[10] = new Drink("Moscow Snow", "FRWW", this, "Drinks/MoscowSnow.png");
		
		badDrink = new Drink("!#%@", "", this, "Drinks/Empty.png");
	}
	
	public static String GetIngredient(String key){
		String t = ingredients.get(key);
		if(t == ""){
			t = "None";
		}
		return t;
	}
	
	public static String[] ConvertIngredients(String keys){
		//Convert list of keys(ingredients) into a string array of ingredients
		String alphaKeys = SortKeys(keys);
		
		String[] ingredients;
		char[] ingChars = alphaKeys.toCharArray();
		ingredients = new String[ingChars.length];
		for(int i=0; i<ingChars.length; i++){
			String temp = GetIngredient(Character.toString(ingChars[i]));
			ingredients[i] = temp;
		}
		
		return  ingredients;
	}
	
	public static String SortKeys(String keys){
		Character[] chars = new Character[keys.length()];
		
		for(int i=0; i<chars.length; i++){
			chars[i] = keys.charAt(i);
		}
		
		Arrays.sort(chars, new Comparator<Character>(){
			public int compare(Character c1, Character c2){
				int cmp = Character.compare(
					Character.toLowerCase(c1.charValue()),
					Character.toLowerCase(c2.charValue())
				);
				if(cmp != 0){
					return cmp;
				}else{
					return Character.compare(c1.charValue(), c2.charValue());
				}
			}
		});
		
		//Rebuild String
		StringBuilder sb = new StringBuilder(chars.length);
		for(char c : chars){
			sb.append(Character.toUpperCase(c));
		}
		
		return sb.toString();
	}
	
	public static Drink FindDrink(String keys){
		Drink created = badDrink;
		String sKeys = SortKeys(keys);
		System.out.println("Creating from: " + sKeys);
		String[] ings = ConvertIngredients(sKeys);
		for(String s: ings){
			System.out.println(s);
		}
		
		boolean same = false;
		for(int i=0; i<drinks.length; i++){
			if(!same){
				if(ings.length == drinks[i].ingredients.length){
					same = true;
					for(int j=0; j<ings.length; j++){
						if(ings[j].equals(drinks[i].ingredients[j])){
							System.out.println("Ingredient #" + j + " matches");
						}else{
							same = false;
							break;
						}
					}
					if(same){
						created = drinks[i];
						break;
					}
				}
			}
		}
		System.out.println("Created Drink: " + created.name);
		
		return created;
	}
}
