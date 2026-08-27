class Solution {

    public String lexGreaterPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < target.length(); i++) {

            char current = target.charAt(i);

            if (freq[current - 'a'] > 0) {
                ans.append(current);
                freq[current - 'a']--;
                continue;
            }

            int bigger = -1;

            for (int j = current - 'a' + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    bigger = j;
                    break;
                }
            }

            if (bigger != -1) {

                ans.append((char) ('a' + bigger));
                freq[bigger]--;

                for (int j = 0; j < 26; j++) {
                    while (freq[j] > 0) {
                        ans.append((char) ('a' + j));
                        freq[j]--;
                    }
                }

                return ans.toString();
            }

            break;
        }

        for (int i = ans.length() - 1; i >= 0; i--) {

            char old = ans.charAt(i);
            freq[old - 'a']++;

            for (int j = old - 'a' + 1; j < 26; j++) {

                if (freq[j] > 0) {

                    StringBuilder result = new StringBuilder();

                    for (int k = 0; k < i; k++) {
                        result.append(ans.charAt(k));
                    }

                    result.append((char) ('a' + j));
                    freq[j]--;

                    for (int k = 0; k < 26; k++) {
                        while (freq[k] > 0) {
                            result.append((char) ('a' + k));
                            freq[k]--;
                        }
                    }

                    return result.toString();
                }
            }
        }

        return "";
    }
}