package easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * NeetCode Roadmap: Arrays & Hashing
 * Solving Technique: Frequency counter 
 * 							of each index of an int[], size depends: 26 if letters only a-z
 * 							or HashMap, where key is the letter, value is the frequency
 */

public class LC0242_ValidAnagram {
	
	public static void main(String[] args) {
		LC0242_ValidAnagram va = new LC0242_ValidAnagram();
		
		System.out.println(va.isAnagramFrequencyCounterIntegerArray("racecar", "carrace"));
		
		System.out.println(va.isAnagramFrequencyCounterIntegerArray("jar", "jam"));
	}
	
	/*
	 * Input Strings can have any Unicode characters.
	 * 
	 * Frequency counter:
	 * 
	 * Count how many times each character appears.
	 * Use a HashMap for each letter, where key is the letter, and value is how many times the
	 * 		letter appears in the String.
	 * 
	 * 1. Create the Map, only one is needed.
	 * 2. Count frequencies for String s.
	 * 3. Subtract frequencies for String t.
	 * 		If t has a character s didn't have, return false.
	 * 		If count becomes 0, remove the key entirely.
	 * 4. Check if the map is empty.
	 */
	public boolean isAnagramFrequencyCounterHashMap(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++) {
			charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		for(int i = 0; i < t.length(); i++) {
			if(!charCount.containsKey(t.charAt(i))) {
				return false;
			}
			
			if(charCount.get(t.charAt(i)) == 1) {
				charCount.remove(t.charAt(i));
			}
			else {
				charCount.put(t.charAt(i), charCount.get(t.charAt(i)) - 1);
			}
		}
		
		return charCount.isEmpty();
	}
	
	/*
	 * Assumes letters in the input Strings are lowercase a - z.
	 * If the input Strings can have any ASCII characters, then int[] size needs to match it.
	 * 
	 * Frequency counter:
	 * 
	 * Count how many times each character appears.
	 * Use an integer array of size 26 as a bucket because 26 letters in the alphabet.
	 * 
	 * 1. Create an int[] of size 26.
	 * 2. Iterate through the Strings. For every char in the String s, increment the count
	 * 		of the bucket of the respected letter. For every char in the String t, decrement
	 * 		the count of the bucket of the respected letter.
	 * 3. Iterate through the array to check if any of the indices has anything other than 0.
	 */
	public boolean isAnagramFrequencyCounterIntegerArray(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		int[] alphabet = new int[26];
		
		for(int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
			alphabet[t.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * Brute force:
	 * 1. Sort the Strings.
	 * 2. Compare the sorted Strings for equality.
	 */
	public boolean isAnagramSortedString(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		// Step 1
		for(int i = 0; i < s.length() - 1; i++) {
			int minIndex = i;
			
			for(int j = i + 1; j < s.length(); j++) {
				if(s.charAt(minIndex) > s.charAt(j)) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				s = s.substring(0, i) + s.charAt(minIndex) + s.substring(i + 1, minIndex) + s.charAt(i) + s.substring(minIndex + 1);	
			}
		}
		
		for(int i = 0; i < t.length() - 1; i++) {
			int minIndex = i;
			
			for(int j = i + 1; j < t.length(); j++) {
				if(t.charAt(minIndex) > t.charAt(j)) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				t = t.substring(0, i) + t.charAt(minIndex) + t.substring(i + 1, minIndex) + t.charAt(i) + t.substring(minIndex + 1);	
			}
		}
		// End of Step 1
		
		return s.equals(t); // Step 2
	}
	
	/*
	 * Using Java built-in functions
	 * 
	 * Brute force:
	 * 1. Convert both strings to character arrays.
	 * 2. Sort the arrays.
	 * 3. Compare the sorted arrays for equality.
	 */
	public boolean isAnagramSortedArrayBuiltInFunctions(String s, String t) {
		char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        // Import needed from utility package: import java.util.Arrays;
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        return Arrays.equals(sChars, tChars);
	}
	
	/*
	 * Brute force:
	 * 1. Convert both strings to character arrays.
	 * 2. Sort the arrays.
	 * 3. Compare the sorted arrays for equality.
	 */
	public boolean isAnagramSortedArray(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		// Step 1
		char[] sArray = new char[s.length()];
		char[] tArray = new char[t.length()];
		
		for(int i = 0; i < s.length(); i++) {
			sArray[i] = s.charAt(i);
		}
		
		for(int i = 0; i < t.length(); i++) {
			tArray[i] = t.charAt(i);
		}
		// End of Step 1
		
		// Step 2
		for(int i = 0; i < s.length() - 1; i++) {
			int minIndex = i;
			
			for(int j = i + 1; j < s.length(); j++) {
				if(sArray[minIndex] > sArray[j]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				char temp = sArray[minIndex];
				sArray[minIndex] = sArray[i];
				sArray[i] = temp;
			}
		}
		
		for(int i = 0; i < t.length() - 1; i++) {
			int minIndex = i;
			
			for(int j = i + 1; j < t.length(); j++) {
				if(tArray[minIndex] > tArray[j]) {
					minIndex = j;
				}
			}
			
			if(minIndex != i) {
				char temp = tArray[minIndex];
				tArray[minIndex] = tArray[i];
				tArray[i] = temp;
			}
		}
		// End of Step 2
		
		// Step 3
		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i] != tArray[i]) {
				return false;
			}
		}
		// End of Step 3
		
		return true;
	}

}
