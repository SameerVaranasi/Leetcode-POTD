class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            StringBuilder current = new StringBuilder();

            for (int j = i; j < s.length(); j++) {

                if (current.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }

                current.append(s.charAt(j));
                max = Math.max(max, current.length());
            }
        }

        return max;
    }
}