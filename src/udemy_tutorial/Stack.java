package udemy_tutorial;


public class Stack {
	
	private int maxSize;
	private char[] stackArray;
	private int top; //index position of last item placed on top of the stack
	
	
	public Stack(int size){
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1; //initialized tom -1 until further notice
	}
	
	
	public void push(char j) throws Exception{

		if(isFull()){
			System.out.println("Stack overflow");
			throw new Exception();
		}else{
			top++;
			stackArray[top] = j;
		}
	}
	
	public char pop() throws Exception{
		if(isEmpty()){
			System.out.println("Stack underflow");
			throw new Exception();
		

		}else{
			int oldTop = top;
			top--; //item removed
			return stackArray[oldTop];

		}
	}
	
	public char top(){
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
