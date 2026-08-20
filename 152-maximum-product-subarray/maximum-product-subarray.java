class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min=nums[0];
        int ans=nums[0];
        for(int i = 1 ; i<nums.length;i++){
            int num= nums[i];
            int oldmax= max;
            int oldmin= min;
            max=Math.max(num,Math.max(oldmax*num,oldmin*num));
            min=Math.min(num,Math.min(oldmax*num,oldmin*num));
            ans=Math.max(ans,max);

        }
        return ans;
    }
}