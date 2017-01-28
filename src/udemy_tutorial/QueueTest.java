package udemy_tutorial;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<Integer> myQueue = new Queue<Integer>(5);
		myQueue.enQueue(new Integer(5));
		myQueue.enQueue(new Integer(566));
		myQueue.enQueue(new Integer(666));
		myQueue.enQueue(new Integer(10));
		myQueue.enQueue(new Integer(7));
		myQueue.enQueue(new Integer(999));
		
		//note how the order of insertion is maintained.
		
		//this is circular in a way but overrides elements rather than giving exceptions
		myQueue.view();
		
	}

}
