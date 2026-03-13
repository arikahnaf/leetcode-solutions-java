package easy;

import java.util.HashSet;

/*
 * NeetCode Roadmap: Arrays & Hashing
 * Solving Technique: HashSet
 */

public class LC0217_ContainsDuplicate {

	// O(n) running time
	public boolean containsDuplicateHashSet(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		boolean isDuplicate = true;
		
		for(int i = 0; i < nums.length; i++) {
			isDuplicate = set.add(nums[i]);
			
			if(isDuplicate == false) {
				return !isDuplicate;
			}
		}
		
        return !isDuplicate;
	}
	
	/*
	 * Brute force: O(n^2) time complexity
	 * Exceeds time limit, fails in leetcode (logically correct though)
	 */
	public boolean containsDuplicateBruteForce(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
	}
	
}
