class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb=new StringBuilder(num);
        if(k>=num.length())return "0";
        int i;
        for(i=1;i<sb.length();){
            if(k>0&&sb.charAt(i-1)-'0'>sb.charAt(i)-'0'){
                sb.deleteCharAt(i-1);
                i=Math.max(1,i-1);
                k--;
            }else{
                i++;
            }
        }
        while(k>0&&sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        for(i=0;i<sb.length();i++){
            if((sb.charAt(i)-'0')!=0)break;
        }
        String res=sb.substring(i,sb.length());
        return res.equals("")?"0":res;
    }
}
