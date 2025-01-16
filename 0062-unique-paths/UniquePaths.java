class Solution {
    public int uniquePaths(int m, int n) 
    {
        int r=m+n-2;
        int k=Math.min(m-1,n-1);
        long result=1;
        for(int i=1;i<=k;i++)
        {
            result=result*(r-i+1)/i;
        }
        return (int)result;
    }
}
