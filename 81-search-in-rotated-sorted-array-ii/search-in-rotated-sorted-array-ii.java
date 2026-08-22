class Solution {
    public boolean search(int[] nums, int target) {
        boolean isfound=false;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i]==target){
                isfound=true;
            }
        }
        return isfound;
    }
}