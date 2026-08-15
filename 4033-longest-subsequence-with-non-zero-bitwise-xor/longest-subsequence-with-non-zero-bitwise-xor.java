class Solution {
    public int longestSubsequence(int[] nums) {
        int xorvalue =0;
        boolean hasnonzero= false;
        for(int x:nums){
            xorvalue^=x;
            if(x!=0){
                hasnonzero=true;
            }
        }
        if(xorvalue!=0){
            return nums.length;
        }
        if(hasnonzero){
            return nums.length-1;
        }
        return 0;
    }
}