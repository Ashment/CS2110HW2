package bartender;


public class CustomerList implements Runnable{
	Thread thread;
	String threadName;
	CustomerDisplayClass display;
	Customer[] customers;
	Customer currentCustomer;
	Game g;
	
	public static Drink[] drinks = DrinksAndIngredients.drinks;
	public boolean busy;
	
	public CustomerList(CustomerDisplayClass cDisplay, String tName, Game gg){
		threadName = tName;
		display = cDisplay;
		g = gg;
		busy = false;
		
		int customerLine = NumberRandom(6, 15);
		customers = new Customer[customerLine];
		for(int i=0; i<customerLine; i++){
			Drink randomDrink = drinks[NumberRandom(0, drinks.length)];
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
		currentCustomer.cPatience--;
		System.out.println("TICK at: " + threadName + ". Current Paticne = " + currentCustomer.cPatience);
		if(currentCustomer.cPatience <= 0){
			RemoveAt(0);
			display.SetString(currentCustomer.wantedDrink.name);
			display.SetIcon(1);
		}else if(currentCustomer.cPatience <= 6){
			display.SetIcon(3);
		}else if(currentCustomer.cPatience <= Math.floor((currentCustomer.patience / 2))){
			display.SetIcon(2);
		}
	}
	
	public void start(){
		if(thread == null){
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
	
	public static int NumberRandom(int min, int max){
		int range = (max - min);
		return (int)Math.floor((Math.random() * range) + min);
	}
	
	public void ServeDrink(Drink d){
		if(d == currentCustomer.wantedDrink){
			g.KillDrink(false);
			//COMPLETED REQUEST
			RemoveAt(0);
			display.SetString(currentCustomer.wantedDrink.name);
			display.SetIcon(1);
		}
	}
	
	public void RemoveAt(int i) {
		//get at index, remove, and move all customers after up one
		Customer[] newTempArr = new Customer[customers.length-1];
		for(int x=0; x<i; x++){
			newTempArr[x] = customers[x];
		}
		for(int x=i; x<newTempArr.length; x++){
			newTempArr[x] = customers[(x+1)];
		}
		customers = newTempArr;
		
		currentCustomer = customers[0];
	}
}
