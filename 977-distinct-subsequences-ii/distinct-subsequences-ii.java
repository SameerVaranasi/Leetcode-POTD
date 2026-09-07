class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007;

        long[] last = new long[26];
        long dp = 1;

        for (char c : s.toCharArray()) {
            long newDp = (2 * dp - last[c - 'a'] + MOD) % MOD;

            last[c - 'a'] = dp;
            dp = newDp;
        }

        return (int)((dp - 1 + MOD) % MOD);
    }
}