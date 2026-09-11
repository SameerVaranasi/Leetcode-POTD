class Solution {
    public int totalNumbers(int[] digits) {

        int count = 0;

        for (int num = 100; num <= 998; num += 2) {

            int[] freq = new int[10];

            for (int d : digits) {
                freq[d]++;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            freq[a]--;
            freq[b]--;
            freq[c]--;

            boolean possible = true;

            for (int f : freq) {
                if (f < 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}