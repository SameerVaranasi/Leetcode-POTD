class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if( bloomDay.length < (long) m*k){
            return -1;
        }
        int max = bloomDay[0];
        for(int i: bloomDay){
            max = Math.max(max, i);
        }

        int start = 1;
        int end = max;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int bouquets = possible(bloomDay, k, mid);

            if(bouquets < m){
                start = mid + 1;
            }
            else{

                end = mid - 1;
            }
        }
        return start;


    }
    int possible(int[] bloomDay, int k, int day){
        int bouquet = 0;
        int flower = 0;
        for(int i = 0; i<bloomDay.length; i++){
            if(bloomDay[i] - day <= 0){
                flower ++;
                if(flower == k){
                    bouquet ++;
                    flower = 0;
                }
            }
            else{
                flower = 0;
            }
        }
        return bouquet;
    }
}