package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
	private int[] inta;
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
		inta = new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int[] inta2 = new int[inta.length+1];
		//B. set the last element of the new array equal to the integer passed into the method
		inta2[inta2.length-1] = v;
		//C. iterate through the member array and copy all the elements into the new array
		for (int i = 0; i < inta.length; i++) {
			inta2[i] = inta[i];
		}
		//D. set the member array equal to the new array.
		inta = inta2;
	}
	
	
	//4. Complete the steps in the pop method.
	public int pop() {
//		for (int i = 0; i < inta.length; i++) {
//			System.out.println(inta[i]);
//		}
//		System.out.println("");
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int vv = inta[inta.length-1];
		//B. create a new array that is one element smaller than the member array
		int[] inta3 = new int[inta.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for (int i = 0; i < inta3.length; i++) {
			inta3[i] = inta[i];
		}
		//D. set the member array equal to the new array
		inta = inta3;
		//E. return the variable you created in step A
//		for (int i = 0; i < inta.length; i++) {
//			System.out.println(inta[i]);
//		}
		//System.out.println(vv);
		return vv;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		inta = new int[0];
	}
	
	//6. Complete the size method to return 
	//   the length of the member array
	public int size() {
		return inta.length;
	}
}
