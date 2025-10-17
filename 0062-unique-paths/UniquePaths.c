int rec(int m,int n,int**cache){
    if(m==1||n==1){
        cache[m-1][n-1]=1;
        return 1;
    }
    else{
        int k;
        if(cache[m-2][n-1]!=0&&cache[m-1][n-2]!=0){
            k=cache[m-2][n-1]+cache[m-1][n-2];
        }
        else{

        if(cache[m-2][n-1]!=0){
            k=cache[m-2][n-1]+rec(m,n-1,cache);
        }
        if(cache[m-1][n-2]!=0){
            k=rec(m-1,n,cache)+cache[m-1][n-2];
        }
        }
        if(cache[m-2][n-1]==0&&cache[m-1][n-2]==0){
           k=rec(m-1,n,cache)+rec(m,n-1,cache);
        }
        cache[m-1][n-1]=k;
        return k;
    }

}
int uniquePaths(int m, int n) {
    int**cache = (int**)malloc(sizeof(int*)*m);
    for(int i=0;i<m;i++){
        cache[i] = (int*)calloc(sizeof(int),n);
    }
    return rec(m,n,cache);
}
