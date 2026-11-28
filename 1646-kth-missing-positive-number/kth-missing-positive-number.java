import java.util.*;
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        Set<Integer> num = new HashSet<>();
        for(int z : arr){
            num.add(z);
        }
        int i =1;
        while(true){
            if(!num.contains(i)){
                k--;
                if(k == 0){
                    return i;
                }
            }
            i++;
            
        }
    }
}