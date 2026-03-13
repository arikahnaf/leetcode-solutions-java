package easy;

import java.util.Stack;

/*
 * NeetCode Roadmap: Stack
 * Solving Technique: Stack
 */

public class LC0020_ValidParentheses {
	
	// Stack implementation
	public boolean isValidStack(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			}
			else if(s.charAt(i) == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			}
			else if(s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			}
			else {
				return false;
			}
		}
		
		return stack.isEmpty();
	}
	
	// Manual stack implementation using an array and an int variable
	public boolean isValidForLoop(String s) {
		char[] c = new char[s.length()];
		int top = -1;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				top++;
				c[top] = s.charAt(i);
			}
			else {
				if(top == -1) {
					return false;
				}
				
				if(s.charAt(i) == ')' && c[top] == '(' || 
				   s.charAt(i) == ']' && c[top] == '[' || 
				   s.charAt(i) == '}' && c[top] == '{') {
					top--;
				}
				else {
					return false;
				}
			}
		}
		
		return top == -1;
	}

}
