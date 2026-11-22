class Solution {
    public void genarate(List<String> result ,int max ,int open ,int close,String unprocesed){
        if(unprocesed.length()==2*(max)){
            result.add(unprocesed);
            return;
        }
        if(open<max){
            genarate(result,max,open+1,close,unprocesed+'(');
        }
        if(close<open){
            genarate(result,max,open,close+1,unprocesed+')');
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        genarate(result,n,0,0,"");
        return result;
    }
}