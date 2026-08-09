class Solution {
    const int inf = 1234567890;
    int get(const vector<int> &p, vector<vector<int>> &dp, int n, int m) {
        m = min(static_cast<int>(p.size() - n + 1) >> 1, m);
        if (dp[n][m] > -inf) return dp[n][m];
        if (n == p.size()) return dp[n][m] = 0;
        const int num = m << 1;
        for (int i = 1, sum = 0, j = n; i <= num && j < p.size(); ++i) {
            sum += p[j++];
            dp[n][m] = max(dp[n][m], sum - get(p, dp, j, max(m, i)));
        }
        return dp[n][m];
    }
public:
    int stoneGameII(vector<int>& piles) {
        const int n = piles.size();
        vector<vector<int>> dp(n + 1, vector<int>(n + 1, -inf));
        int r = get(piles, dp, 0, 1);
        for (int p : piles) {
            r += p;
        }
        return r >> 1;
        
    }
};