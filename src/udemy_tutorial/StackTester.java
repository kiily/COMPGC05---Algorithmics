package udemy_tutorial; 

public class StackTester {

	public static void main(String[] args) throws Exception {
		
		Stack theStack = new Stack(4);
		
		theStack.push('a');
		theStack.push('b');
		theStack.push('c');
		theStack.push('d');
		
		while(!theStack.isEmpty()){
			long value = theStack.pop();
			System.out.println(value);
			//80 printed first (LIFO)
		}
		
		String word1 = "NINA FOZZARD";
		String reversedWord1 = reverseWord(word1);
		System.out.println(reversedWord1);
		
		String word2 = "MIGUEL MARIN";
		String reversedWord2 = reverseWord(word2);
		System.out.println(reversedWord2);
		
	}

	public static String reverseWord(String word) throws Exception{
		
		//max stack size
		int stackSize = word.length();
		
		Stack letters = new Stack(stackSize);
		
		for(int i =0; i<stackSize; i++){
			char letter = word.charAt(i);
			letters.push(letter);
		}
		
		String reversedWord="";
		
		
		while(!letters.isEmpty()){//while the stack is not empty
			reversedWord += letters.pop();
		
		}
		
		return reversedWord;
	}
}
