class Solution {
    public int maxArea(int[] height) {
        int last = height.length-1;
        int first = 0;
        int count = 0;
        int count2 = 0;
        while(first < last){
            if (height[first] < height[last]) {
                count2 = (last - first) * height[first];
                first++;
            }else{
                count2 = (last-first) * height[last];
                last--;

            }
            count = Math.max(count,count2);

        }
        return count;

    }
}