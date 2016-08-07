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
	
	int customerWait;
	
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
		currentCustomer = null;
		customerWait = NumberRandom(3, 13);
		display.SetString(" ");
		display.SetIcon(0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;){
			//Customer List Loop
			try {
				Thread.sleep(NumberRandom(1100, 1500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tick();
		}
	}
	
	public void tick(){
		//per tick
		if(currentCustomer != null){
			currentCustomer.cPatience--;
			System.out.println("TICK at: " + threadName + ". Current Paticne = " + currentCustomer.cPatience);
			if(currentCustomer.cPatience <= 0){
				RemoveAt(0);
				g.sfx.SetSound("CustomerLeft.wav");
				g.sfx.Play();
				display.SetString(currentCustomer.wantedDrink.name);
				display.SetIcon(1);
			}else if(currentCustomer.cPatience <= 6){
				display.SetIcon(3);
			}else if(currentCustomer.cPatience <= Math.floor((currentCustomer.patience / 2))){
				display.SetIcon(2);
			}
		}else{
			if(customerWait > 0){
				customerWait--;
			}else{
				if(customers.length > 0){
					currentCustomer = customers[0];
					display.SetString(currentCustomer.wantedDrink.name);
					display.SetIcon(1);
				}
			}
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
			g.sfx.SetSound("DrinkServed.wav");
			g.sfx.Play();
			//COMPLETED REQUEST
			RemoveAt(0);
			customerWait = NumberRandom(6, 19);
			currentCustomer = null;
			display.SetString(" ");
			display.SetIcon(0);
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
		
		//currentCustomer = customers[0];
	}
}
