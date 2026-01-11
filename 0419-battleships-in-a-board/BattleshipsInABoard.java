class Solution {
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][]vis = new boolean[n][m];
        int field  = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j]=='X'){
                    field++;
                    vis[i][j]=true;
                    if(i+1<n && !vis[i+1][j] && board[i+1][j]=='X'){
                    dfsR(i+1,j,vis,board,n,m);
                    }
                    else if(j+1 <m && !vis[i][j+1] && board[i][j+1]=='X'){
                    dfsC(i,j+1,vis,board,n,m);
                    }
                }
        }
    }
     return field; 
    }
    private void dfsR(
        int row,
        int col,
        boolean [][]vis,
        char[][] board,
        int n,
        int m){
        vis[row][col]=true;
        if(row+1>=0 && col>=0 && row+1<n && col<m && board[row+1][col]=='X' && !vis[row+1][col]){
            dfsR(row+1,col,vis,board,n,m);
        }
      }
        private void dfsC(
        int row,
        int col,
        boolean [][]vis,
        char[][] board,
        int n,
        int m){
        vis[row][col]=true;
        if(row>=0 && col+1>=0 && row<n && col+1<m && board[row][col+1]=='X' && !vis[row][col+1]){
            dfsC(row,col+1,vis,board,n,m);
        }
        }
    }
