class Solution {
    public boolean canAliceWin(int n) {
        int counter = 0;
        for(int i = 10 ; i>=0 ; i--){
            n=n-i;
            counter++;
            if(n<0){
                return counter%2 == 0;
            }
        }
        return false;
    }
}