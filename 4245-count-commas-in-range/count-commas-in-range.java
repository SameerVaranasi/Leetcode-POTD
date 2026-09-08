class Solution {
    public int countCommas(int n) {

        if (n < 1000) {
            return 0;
        }
        if (n <= 9999) {
            return n - 1000 + 1;
        }
        if (n <= 99999) {
            return (9999 - 1000 + 1) + (n - 10000 + 1);
        }
        if (n <= 999999) {
            return (99999 - 1000 + 1) + (n - 100000 + 1);
        }
        return (999999 - 1000 + 1)
                + 2 * (n - 1000000 + 1);
    }
}