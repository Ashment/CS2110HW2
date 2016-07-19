package hw3;

public class Queue implements customerQueue{
	public String name;
	Customer[] queue;
	
	//Constructor
	public Queue(String n){
		name = n;
		queue = new Customer[0];
	}
	
	
	//Methods from interface
	@Override
	public Customer GetCustomerAt(int i) {
		//return customer if index is in range
		if(i < queue.length){
			return queue[i];
		}else{
			return null;
		}
	}
	
	@Override
	public int GetSize() {
		//return length of queue
		return queue.length;
	}
	
	@Override
	public void AddToQueue(String s) {
		//If only passed a name, create customer and add
		Customer temp = new Customer(s);
		AddToQueue(temp);
	}
	
	@Override
	public void AddToQueue(Customer c) {
		//if provided a customer, add customer directly
		Customer[] newTempArr = new Customer[queue.length+1];
		//copy customers over to new list
		for(int i=0; i<queue.length; i++){
			newTempArr[i] = queue[i];
		}
		newTempArr[queue.length] = c;
		queue = newTempArr;
	}
	
	@Override
	public void RemoveAt(int i) {
		//get at index, remove, and move all customers after up one
		Customer[] newTempArr = new Customer[queue.length-1];
		for(int x=0; x<i; x++){
			newTempArr[x] = queue[x];
		}
		for(int x=i; x<newTempArr.length; x++){
			newTempArr[x] = queue[(x+1)];
		}
		queue = newTempArr;
	}
	
	@Override
	public Customer[] CustomerAlphabetical() {
		Customer[] alphabeticalC = new Customer[queue.length];
		//copy elements over
		for(int i=0; i<queue.length; i++){
			alphabeticalC[i] = queue[i];
		}
		
		//loop through all names in return array
		for(int i=0; i<alphabeticalC.length; i++){
			for(int j=i+1; j<alphabeticalC.length; j++){
				//compare names, and switch spots
				if(alphabeticalC[i].name.compareTo(alphabeticalC[j].name)>0){
					Customer temp = alphabeticalC[i];
					alphabeticalC[i] = alphabeticalC[j];
					alphabeticalC[j] = temp;
				}
			}
		}
		
		return alphabeticalC;
	}

	@Override
	public int GetLength() {
		//return length of queue
		return queue.length;
	}
}
