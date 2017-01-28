package udemy_tutorial;



/**
 * This is the implementation for a singly linked list.
 * This data struture makes use of a node class.
 * 
 * Additionaly this is implemented using both a listHead and a listTail pointer.
 * This is a circular linked list
 * @author migue
 *
 * @param <E>
 */
public class LinkedList<E>{
	
	
	private Node listHead;//pointer first node
	private Node listTail;//last node
	
	
/**
 * The udemy course asked to create a separate node class; I encapsulated it in 
 * this version of the LinkedList data structure in order to be able to use
 * generics.
 * 
 * This is a recursive class definition.
 * 
 * @author migue
 *
 */
protected class Node {
	

	protected E data;
	protected Node next;
	
	//node with no pointer
	public Node(E e){
		this(e, null);
	}
	
	public Node(E e, Node n){
		data = e;
		next = n;
	}
	
	public void printNode(){
		System.out.println(("{ "+data+" }"));
	}
	
}


	public LinkedList(){
		listHead = null;
		listTail = null;
	}

	public boolean isEmpty(){
		return (listHead == null);
	}
	
	
	//inserting an element at the beggining of the list
	public void insertFirst(E e){
		
	if(isEmpty()){
		
	listHead = new Node(e);
	listTail = listHead; //both pointers to the same node
	
	}else{
		Node currentNode = listHead;
		
		Node newNode = new Node(e, currentNode);
		
		listHead = newNode;
		 		
	}
	
			
	}
	
	public void deleteFirst() throws Exception{
		
		//cannot delete if the list is empty
		if(isEmpty()){
			throw new Exception("List underflow");
			
		}
		
		//in the case that there is only one item
		if(listHead.next ==null){
			listHead = null;
			listTail = null;
		}
		
		//general case
		else{
			listHead = listHead.next;
		}
	}
	
	public void insertLast(E e){
		
		if(isEmpty()){
			listHead = new Node(e);
			listTail = listHead; //both pointers to the same node
		}
		
		else{
			listTail.next = new Node(e);//the last node points to null
			listTail = listTail.next;
			
		}
	}
	
	public void deleteLast() throws Exception{
		//cannot delete if the list is empty
		if(isEmpty()){
			throw new Exception("List underflow");

		}

		//in the case that there is only one item
		if(listHead.next ==null){
			listHead = null;
			listTail = null;
		
		//need to traverse the array as we cannot go back
		//DOUBLY-LINKED LISTS can go back without traversal
		}else{
			Node currentNode = listHead;
			
			while(currentNode.next != listTail){
				currentNode = currentNode.next;
				
			}
		
			//currentNode.next now points to the element right before the 
			//listTail
			currentNode.next = null;
			listTail = currentNode;
		}

	}
	
	public void printList(){
		System.out.println("List (first --> last)");
		Node current = listHead;
		while(current != null){
			current.printNode();
			
			//current instead of listHead because we don't want the loop to modify this variable
			current = current.next;
			
		}
	}
}
	
	
