package easy;

import java.util.HashMap;

/*
 * NeetCode Roadmap: Arrays & Hashing
 * Solving Technique: HashMap key-value pairs
 */

public class LC0001_TwoSum {

	// Map implementation
	public int[] twoSumMap(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
				
			map.put(nums[i], i);
		}

		return null;
	}
	
	// Brute force using nested for loop
	public int[] twoSumBruteForce(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					int[] result = {i, j};
					return result;
				}
			}
		}
		return null;
	}

}
