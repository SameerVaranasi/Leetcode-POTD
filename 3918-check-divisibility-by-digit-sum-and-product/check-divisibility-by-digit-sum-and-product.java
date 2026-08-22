class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0;
        int prod = 1;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            prod *= digit;
            n /= 10;
        }

        int ttl = sum + prod;
        return temp % ttl == 0;
    }
}