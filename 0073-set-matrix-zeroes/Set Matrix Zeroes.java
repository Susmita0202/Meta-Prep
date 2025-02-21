class Solution {
    public void setZeroes(int[][] matrix) {
        boolean f1=false, f2=false;

        int n=matrix.length, m=matrix[0].length;
        for(int i=0; i<n; i++){
            if(matrix[i][0] == 0){
                f1=true;
            }
        }
        for(int j=0; j<m; j++){
            if(matrix[0][j] == 0){
                f2=true;
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] =0;
                
            }
        }
    }
    for(int i=1; i<n; i++){
        for(int j=1; j<m; j++){
            if(matrix[i][0] == 0 || matrix[0][j]==0){
                matrix[i][j] = 0;
            }
        }
    }
    if(f1){
        for(int i=0; i<n; i++){
            matrix[i][0] =0;
        }
    }
    if(f2){
        for(int j=0; j<m;j++){
            matrix[0][j]=0;
        }
    }
}
}
