package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();		
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int i = 0; i < 100; i++) {
			doubles.push(new Random().nextDouble()*100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String input1 = JOptionPane.showInputDialog("Enter in a number between 0 and 100, inclusive.");
		String input2 = JOptionPane.showInputDialog("Enter in another number between 0 and 100, inclusive.");
		
		int smallernum = 0;
		int largernum = 0;
		
		if (Integer.parseInt(input1) > Integer.parseInt(input2)) {
			largernum = Integer.parseInt(input1);
			smallernum = Integer.parseInt(input2);
		} else {
			largernum = Integer.parseInt(input2);
			smallernum = Integer.parseInt(input1);
		}
		
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		System.out.println("Popping elements off stack...");
		System.out.println("Elements between " + smallernum + " and " + largernum + ":");
		
		
		for (int i = 0; i < doubles.size(); i++) {
			double poppingdouble = doubles.pop();
			if (smallernum < poppingdouble && poppingdouble < largernum) {
				System.out.println(poppingdouble);
			}
		}	
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
