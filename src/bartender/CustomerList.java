package bartender;

public class CustomerList implements Runnable{
	Thread thread;
	String threadName;
	CustomerDisplayClass display;
	Customer[] customers;
	Customer currentCustomer;
	
	public static Drink[] drinks = DrinksAndIngredients.drinks;
	
	public CustomerList(CustomerDisplayClass cDisplay, String tName){
		threadName = tName;
		display = cDisplay;
		
		int customerLine = NumberRandom(6, 13);
		customers = new Customer[customerLine];
		for(int i=0; i<customerLine; i++){
			Drink randomDrink = drinks[NumberRandom(0, (drinks.length - 1))];
			customers[i] = new Customer(randomDrink);
		}
		currentCustomer = customers[0];
		display.SetString(currentCustomer.wantedDrink.name);
		display.SetIcon(1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			//Customer List Loop
			try {
				Thread.sleep(NumberRandom(1050, 1350));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tick();
		}
	}
	
	public void tick(){
		//per tick
	}
	
	public void start(){
		if(thread == null){
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	public static int NumberRandom(int min, int max){
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}
}
