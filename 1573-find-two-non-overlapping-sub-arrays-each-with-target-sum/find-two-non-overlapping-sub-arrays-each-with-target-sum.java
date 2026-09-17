class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int ans = n+1;
        int sum = 0;
        int [] dp = new int[n+1];
        Arrays.fill(dp,n);
        for(int i = 0 , r = 0 ; r < n ; r++){
            sum+=arr[r];
            while(sum > target){
                sum-=arr[i++];
            }
            dp[r+1]=dp[r];
            if(sum == target){
                ans = Math.min(ans,r-i+1+dp[i]);
                dp[r+1]=Math.min(dp[r],r-i+1);
            }
        }
        return ans == n+1 ? -1: ans;
    }
}