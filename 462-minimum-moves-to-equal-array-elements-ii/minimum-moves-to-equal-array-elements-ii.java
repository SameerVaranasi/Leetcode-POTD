import java.util.Arrays;
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int total = 0;
        int median = nums[nums.length/2];
        for(int num : nums){
            total+=Math.abs(median-num);

        }
        return total;
    }
}