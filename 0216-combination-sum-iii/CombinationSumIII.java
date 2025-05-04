class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>al = new ArrayList<>();
        combinationSum3(k,n,1,al,ans);
        return ans;
    }
    public void combinationSum3(int k,int n,int i,List<Integer>al,List<List<Integer>>ans){

        if(k == 0){
            if(n == 0){
                ans.add(new ArrayList<>(al));

            }

            return;
        }


        for(int j = i;j <= 9;j++){
            if(n - j >= 0){
                al.add(j);
                combinationSum3(k-1,n-j,j+1,al,ans);
                al.remove(al.size()-1);
            }
        }

    }
}
