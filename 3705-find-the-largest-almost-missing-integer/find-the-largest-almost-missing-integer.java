class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0;i<=nums.length-k;i++){ //checking the loop
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j<i+k;j++){
                set.add(nums[j]);
                //close the loop
            }
            // another for loop
            for(int num:set){
                map.put(num,map.getOrDefault(num,0)+1); // make note of this line for future ref. from gpt**
            }
        }
        int ans =-1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){//fumctiom** from gemini new one
                ans= Math.max(ans,entry.getKey());
            }

        }
        return ans;
    }
}