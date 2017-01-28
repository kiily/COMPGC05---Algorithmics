package udemy_tutorial;
/**
 * This is a circular implementation but causes overriding rather tha giving an exception
 * We can throw exceptions instead and not allow overridding.
 * @author migue
 *
 * @param <E>
 */
public class Queue<E> {

	private int maxSize;
	private E[] queueArray;
	private int front;//index for the element in the front
	private int rear; //index position for the element at the back of the line
	private int nItems; //counter for number of items in queue
	
	@SuppressWarnings("unchecked")
	public Queue(int size){
		this.maxSize = size;
		this.queueArray = (E[]) new Object[size];
		front = 0; //index position of first slot in array
		rear=-1;//there is no item yet to be the rear
		nItems =0 ; //no elements in array yet
		
	}
	
	
	//inserting an item in the queue
	public void enQueue(E e){
		
		if(isFull())
		
		if(rear == maxSize -1){
			rear =-1;
		}
		
		rear++;
		queueArray[rear] = e;
		nItems++;
	}
	
	//remove from front of the queue
	public E deQueue(){
		E deQueued = queueArray[front];
		front++;
		
		if(front == maxSize){
			front = 0; 
		}
		nItems--;
		
		
		return deQueued;
	}
	
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == maxSize;
	}
	
	
	//will print out the queueArrays
	public void view(){
		System.out.print("[ ");
		
		for (int i = 0; i < queueArray.length; i++) {
			System.out.print(queueArray[i]+" ");
		}
		System.out.print("]");
	}
	
	
	//checks who is at the front
	public E peekFront(){
		return queueArray[front];
		
	}
}
