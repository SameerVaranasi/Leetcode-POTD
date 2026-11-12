
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            int inc = 1;
            int dec = 1;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] > nums[j-1]) {
                    if(dec>1)break;
                    inc++;
                }
                else if (nums[j] < nums[j-1]) {
                    if(inc>1)break;
                    dec++;
                }
                else {
                    break;
                }

                max = Math.max(max,Math.max(inc,dec));
                
            }
        }

        return max;
    }
}
