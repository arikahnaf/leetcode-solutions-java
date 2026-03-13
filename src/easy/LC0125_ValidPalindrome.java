package easy;

/*
 * NeetCode Roadmap: Two Pointers
 * Solving Technique: Two Pointers
 */

public class LC0125_ValidPalindrome {

	// Two pointers
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while(left < right) {
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);

			if(!(leftChar >= 'a' && leftChar <= 'z') &&
					!(leftChar >= 'A' && leftChar <= 'Z') &&
					!(leftChar >= '0' && leftChar <= '9')) {
				left++;
				continue;
			}
			if(!(rightChar >= 'a' && rightChar <= 'z') &&
					!(rightChar >= 'A' && rightChar <= 'Z') &&
					!(rightChar >= '0' && rightChar <= '9')) {
				right--;
				continue;
			}

			if(leftChar >= 'A' && leftChar <= 'Z') {
				leftChar = (char)(leftChar + 'a' - 'A');
			}
			if(rightChar >= 'A' && rightChar <= 'Z') {
				rightChar = (char)(rightChar + 'a' - 'A');
			}

			if(leftChar != rightChar) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	// Two pointers + using Java built-in isLetterOrDigit(char c) utility method
	public boolean isPalindromeAnswer(String s) {
		if(s == null) {return false;}

		int left = 0;
		int right = s.length() - 1;

		while(left < right) {
			// Lowercase leftmost & rightmost digit
			char leftChar = Character.toLowerCase(s.charAt(left));
			char rightChar = Character.toLowerCase(s.charAt(right));

			// Ignore non-alphanumeric characters
			if(!Character.isLetterOrDigit(leftChar)) {
				left++;
				continue;
			}
			if(!Character.isLetterOrDigit(rightChar)) {
				right--;
				continue;
			}

			// Check if leftChar and rightChar are not same
			if(leftChar != rightChar) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}
	
	// Using recursion (with helper method)
	public boolean isPalindromeRecursion(String s) {
		if(s == null) {
			throw new IllegalArgumentException("Input string is null");
		}
		
		String cleanedString = "";
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
				continue;
			}
			
			if(c >= 'A' && c <= 'Z') {
				c = (char)(c + 'a' - 'A');
			}
				
			cleanedString += c;
		}
		
		return isPalindromeRecursionHelper(cleanedString);
	}
	private boolean isPalindromeRecursionHelper(String s) {
		if(s.length() <= 1) {
			return true;
		}
		
		char leftChar = s.charAt(0);
		char rightChar = s.charAt(s.length() - 1);
		
		if(leftChar != rightChar) {
			return false;
		}
		
		if(s.length() == 2) {
			return leftChar == rightChar;
		}
		else {
			return isPalindromeRecursionHelper(s.substring(1, s.length() - 1));
		}
	}

}
