package hw3;

public interface customerQueue {
	public Customer GetCustomerAt(int i);
	public int GetSize();
	public void AddToQueue(String s);
	public void AddToQueue(Customer c);
	public void RemoveAt(int i);
}
