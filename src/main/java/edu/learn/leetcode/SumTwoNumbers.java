package edu.learn.leetcode;

public class SumTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];

        if(nums != null && nums.length > 1){
            for(int i = 0 ; i < nums.length; i++){
                for(int j = i; j < nums.length -1 ; j++){
                    if(nums[i] + nums[j + 1] == target){
                        indexes[0] = i;
                        indexes[1] = j + 1;
                        return indexes;
                    }
                }
            }
        }

        return indexes;
    }

    public static void main(String[] args) {
        SumTwoNumbers sumTwoNumbers = new SumTwoNumbers();
        //int[] result = sumTwoNumbers.twoSum(new int[]{1,2,3,4,5}, 3);
        //int[] result = sumTwoNumbers.twoSum(new int[]{1,2,3,4,5}, 5);
        int[] result = sumTwoNumbers.twoSum(new int[]{1,2,3,4,5}, 4);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}