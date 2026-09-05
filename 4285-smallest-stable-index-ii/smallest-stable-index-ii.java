class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] minvalue = new int[n];
        minvalue[n-1]=nums[n-1];
        for(int i = n-2;i>=0;i--){
            minvalue[i]=Math.min(minvalue[i+1],nums[i]);
        }
        int maxvalue=0;
        for(int i = 0 ; i<n;i++){
            maxvalue=Math.max(maxvalue,nums[i]);
            if(maxvalue-minvalue[i]<=k){
                return i;
            }
        }
        return -1;
    }
}