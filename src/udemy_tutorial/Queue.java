package udemy_tutorial;

public class Queue {

	private int maxSize;
	private long[] queueArray;
	private int front;//index for the element in the front
	private int rear; //index position for the element at the back of the line
	private int nItems; //counter for number of items in queue
	
	public Queue(int size){
		this.maxSize = size;
		this.queueArray = new long[size];
		front = 0; //index position of first slot in array
		rear=-1;//there is no item yet to be the rear
		nItems =0 ; //no elements in array yet
		
	}
	
	
	//inserting an item in the queue
	public void enQueue(long j){
		rear++;
		
	}
}
