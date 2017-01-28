package udemy_tutorial;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList<Integer> myList = new LinkedList<Integer>();
		
		myList.insertFirst(new Integer(100));
		myList.insertFirst(new Integer(90));
		myList.insertFirst(new Integer(19900));
		myList.insertLast(new Integer(1000000000));
		
		myList.printList();
	}

}
