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
}
