class Solution {
    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;
        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                int i = l;
                int j = r;

                int leftSum = stoneValue[i];
                int rightSum = stoneValue[j];

                while (i < j) {

                    if (leftSum < rightSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][i]
                        );

                        i++;
                        leftSum += stoneValue[i];

                    } else if (rightSum < leftSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[j][r]
                        );

                        j--;
                        rightSum += stoneValue[j];

                    } else {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][i],
                                dp[j][r]
                            )
                        );

                        i++;
                        j--;

                        if (i < n)
                            leftSum += stoneValue[i];

                        if (j >= 0)
                            rightSum += stoneValue[j];
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}


//pruning optimization