package lecture2;

public class QueueArrayTest {

	public static void main(String[] args) throws QueueException {

		
		QueueArray<Integer> myQueue = new QueueArray<Integer>(5);
		
		
		try{
			myQueue.enQueue(new Integer(99));
			myQueue.enQueue(new Integer(99));
			myQueue.enQueue(new Integer(99));
			myQueue.enQueue(new Integer(99));
			myQueue.enQueue(new Integer(99));
		
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
