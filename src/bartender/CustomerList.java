package bartender;

public class CustomerList implements Runnable{
	CustomerClass display;
	
	public static String[] drinks = {""};
	
	public CustomerList(CustomerClass cu){
		display = cu;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
