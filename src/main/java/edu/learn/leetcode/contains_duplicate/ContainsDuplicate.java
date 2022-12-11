package edu.learn.leetcode.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /*if(nums != null && nums.length > 1){
            if(nums[0] == nums[1]){
                return true;
            }

            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1 ; j < nums.length; j++){
                    if(nums[i] == nums[j]){
                        return true;
                    }
                }
            }
        }*/

        Set<Integer> storeNums = new HashSet<>();
        for(int i : nums){
            if(!storeNums.add(i)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        //int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{1,2,3,4};
        //int[] nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        containsDuplicate.containsDuplicate(nums);
    }
}
