package udemy_tutorial;


public class Stack<E> {
	
	private int maxSize;
	private E[] stackArray;
	private int top; //index position of last item placed on top of the stack
	
	
	@SuppressWarnings("unchecked")
	public Stack(int size){
		this.maxSize = size;
		this.stackArray = (E[]) new Object[maxSize];
		this.top = -1; //initialized tom -1 until further notice
	}
	
	
	public void push(E e) throws Exception{

		if(isFull()){
			System.out.println("Stack overflow");
			throw new Exception();
		}else{
			top++;
			stackArray[top] = e;
		}
	}
	
	public E pop() throws Exception{
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception();
		

		}else{
			int oldTop = top;
			top--; //item removed
			return stackArray[oldTop];

		}
	}
	
	public E top(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return(maxSize-1 == top);
		//-1 to account for the fact that index starts at 0;
	}
	

}
