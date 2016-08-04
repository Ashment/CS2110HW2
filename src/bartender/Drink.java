package bartender;

public class Drink {
	public String name;
	public String[] ingredients;
	DrinksAndIngredients m;
	
	public Drink(String n, String ing, DrinksAndIngredients di){
		name = n;
		m = di;
		
		ingredients = m.ConvertIngredients(ing);
		
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
		
		return s;
	}
}
