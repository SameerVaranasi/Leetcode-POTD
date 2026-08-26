class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int lengthmin=Integer.MAX_VALUE;
        for(int i = 0; i<s.length();i++){
            int count = 0 ;
            for(int j=i;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    count++;
                }
                if(count==k){
                    String current = s.substring(i,j+1);
                    if(current.length()<lengthmin){
                        ans=current;
                        lengthmin=current.length();

                    }else if(current.length()==lengthmin && current.compareTo(ans)<0){
                        ans=current;
                    }
                }
                if(count>k){
                    break;
                }
                
            }
        }
        return ans;
    }
}