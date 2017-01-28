package udemy_tutorial;

import org.omg.CORBA.Current;

public class DoublyLinkedList<E> {

	
	//would be useful to have a variable for the size of the list that can
	//be printed at the end
	//encapsulated Node class
	protected class Node {
		
		protected E data;
		protected Node next;
		protected Node prev;
		
		//node with no pointer
		public Node(E e){
			this(e, null, null);
		}
		
		
		public Node(E e, Node n, Node p){
			data = e;
			next = n;
			prev = p;
		}
		
		public void printNode(){
			System.out.println(("{ "+data+" }"));
		}
		
	}
	
	private Node first;
	private Node last;
	
	public DoublyLinkedList(){
		//explicitly initialize to null
		this.first = null;
		this.last = null;
	
	}
	
	public boolean isEmpty(){
		return first ==null;
	}
	
	public void insertFirst(E e){
		
		
		if(isEmpty()){
			first = new Node(e);
			last = first;
		}
		else{
			first.prev = new Node(e);
			first.prev.next = first;
			
			first = first.prev;
			
		}
		
	}
	
	
	public void insertLast(E e){
		if(isEmpty()){
			first = new Node(e);
			last = first;
		}
		
		else{
			Node newNode = new Node(e);
			last.next = newNode;
			newNode.prev = last;
			
			last = newNode;
			
		}
		
	}
	
	public void printList(){

		Node current = first;
		while(current != null){
			current.printNode();
			
			current = current.next;
			
		}
		
		System.out.println();
	}
	
	
	public void deleteFirst() throws Exception{
	
		if(isEmpty()){
			throw new Exception("No elements to delete");
			
		}
		
		//case in which it is the only element
		if(first.next == null){
			first = null;
			last = null;
		}
		
		else{
			first.next.prev = null;//list's first node points back to null
			first = first.next;
		}
	}
	
	public void deleteLast() throws Exception{
		
		if(isEmpty()){
			throw new Exception("No elements to delete");
			
		}
		
		//case in which it is the only element
		if(first.next == null){
			first = null;
			last = null;
		}
		
		else {
			
			//don't forget that the penultimate element's reference points to 
			//the last element which we want to remove.
			last.prev.next = null;
			last = last.prev;
		}
	}
	
	//insert a node at a specified index. i.e. after the node at that spot
	//if an already existing position is filled, then the value will be overridden
	public void insertAt(E e, int index) throws Exception{
		
		//index needs to be valid
		if(index < 0 ){
			throw new Exception("Index is a positive integer");
			
		}
		
		//if the list is empty
		if(first == null){
			if(index == 0){
				first = new Node(e);
				last = first;

			}else{
				throw new Exception("Index is out of range");
			}
		}

		//insertion at position 0 in a non-empty list
		//call the insert first for an easier implementation
		//do the same for insert last
		else if(index == 0 ){
			first.prev = new Node(e);
			first.prev.next = first;

			first = first.prev;
		}
		//general case
		else{
			//need to iterate over list
			Node current = first;

			int currentPosition = 1;

			while(currentPosition < index){
				current = current.next;
				currentPosition++;
			}


			//at the end of the loop the current position corresponds to where we want 
			//to insert the object; this is the position of the new Node
			Node newNode = new Node(e, current.next, current);


			//in the case that this is at the end of the list; update the tail pointer
			if(current.next == null){
				last = newNode;
				current.next = newNode;

			}else{
				current.next.prev = newNode;
				current.next = newNode;
			}

	
		
		}
		
	}
	
	
}
