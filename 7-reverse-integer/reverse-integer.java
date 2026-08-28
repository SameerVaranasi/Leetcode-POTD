class Solution {
    public int reverse(int x) {
        long finalnum=0;
        while(x!=0){
            int lastdigit= x%10;
            finalnum+=lastdigit;
            finalnum=finalnum*10;
            x=x/10;
        }
        finalnum=finalnum/10;
        if(finalnum> Integer.MAX_VALUE || finalnum<Integer.MIN_VALUE){
            return 0 ; 
        }
        if(x<0){
            return (int)(-1*finalnum);
        }
        return (int)(finalnum);
    }
}