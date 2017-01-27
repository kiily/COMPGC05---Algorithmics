package lecture1;

public class ArrayExample1 {

	public static void main(String[] args) {
	 int[] array1 = new int[6];
	 int[] array2 = new int[6];
	 
	 array1[0]= 0;
	 array2 = array1;
	 array2[0] =10;
	 
	 System.out.println(array1[0]);
	}

}
