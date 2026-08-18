class Solution {
    public int largestInteger(int[] nums, int k) {

        HashMap<Integer, Integer> window = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        // First window
        for (int i = 0; i < k; i++) {
            window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
        }

        // Count distinct elements in first window
        for (int num : window.keySet()) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Slide the window
        for (int i = k; i < nums.length; i++) {

            int remove = nums[i - k];
            int add = nums[i];

            // Remove left element
            window.put(remove, window.get(remove) - 1);

            if (window.get(remove) == 0) {
                window.remove(remove);
            }

            // Add right element
            window.put(add, window.getOrDefault(add, 0) + 1);

            // Current distinct elements
            for (int num : window.keySet()) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}