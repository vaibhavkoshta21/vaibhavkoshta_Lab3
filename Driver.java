package com.greatlearning.main;
import java.util.Scanner;
import java.util.Stack;


public class Driver {
	public void isBalance(String exp) {
		Stack<Character> st = new Stack<Character>();
		int stackSize = exp.length();
		int count=0;
		if(stackSize != 0) {
			for(int i=0; i<stackSize; i++) {
				char stackElement = exp.charAt(i);
				if((exp.charAt(0) == ')') || (exp.charAt(0) == '}') || (exp.charAt(0) == ']')) {
					count++;
					//continue;
				}
				else if((stackElement == '(') || (stackElement == '[') || (stackElement == '{')) {
					st.push(stackElement);
				}
				else {
					st.pop();
				}
			}
			if(st.empty() && count==0) {
				System.out.println("Balanced Bracket");
			}
			else {
				System.out.println("Not Balanced Bracket");
			}
		}
		else {
			System.out.println("Empty expression");
		}
		
	}
	public static void main(String[] args) {
		Driver bl = new Driver();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression to be evaluated");
		String s = sc.nextLine();
		bl.isBalance(s);
		sc.close();
	}

}
