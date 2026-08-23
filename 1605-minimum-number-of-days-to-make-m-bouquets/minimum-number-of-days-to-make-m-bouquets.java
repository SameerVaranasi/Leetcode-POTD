class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        long total = (long)m * k;

        if(total > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;// maximum value
        int high = Integer.MIN_VALUE;//minimum value

        for(int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = high;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(possible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }

    static boolean possible(int[] bloomDay, int day, int m, int k) {
        int flowers = 0;
        int bouquets = 0;

        for(int i = 0; i < bloomDay.length; i++) {

            if(bloomDay[i] <= day) {
                flowers++;

                if(flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }
            else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}