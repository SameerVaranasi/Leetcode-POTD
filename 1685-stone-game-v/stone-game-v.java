class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        
        // Prefix sum array for O(1) range sum lookups
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        // Interval DP by length
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                int total = prefix[r + 1] - prefix[l];
                int maxScore = 0;
                
                for (int k = l; k < r; k++) {
                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = total - leftSum;
                    
                    if (leftSum < rightSum) {
                        // Optimization: if current score + leftSum can't beat maxScore, skip if needed
                        maxScore = Math.max(maxScore, leftSum + dp[l][k]);
                    } else if (rightSum < leftSum) {
                        maxScore = Math.max(maxScore, rightSum + dp[k + 1][r]);
                    } else {
                        maxScore = Math.max(maxScore, leftSum + Math.max(dp[l][k], dp[k + 1][r]));
                    }
                }
                dp[l][r] = maxScore;
            }
        }
        
        return dp[0][n - 1];
    }
}