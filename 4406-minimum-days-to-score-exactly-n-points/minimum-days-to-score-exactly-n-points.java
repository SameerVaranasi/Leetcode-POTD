class Solution {
    public int minDays(int n) {
        int temp = n;
        int [] dp = new int[n+1];
        dp[0]=-1;
        for(int i = 1 ;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int k = 1 ; k*(k+1)/2<=i;k++){
                int points = k*(k+1)/2;
                dp[i]=Math.min(dp[i],dp[i-points]+k+1);
            }
        }
        return dp[n];
    }
}