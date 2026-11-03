import java.util.Arrays;
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        int median = nums[nums.length-1];
        for(int num : nums){
            total+=Math.abs(median-num);

        }
        return total;
    }
}