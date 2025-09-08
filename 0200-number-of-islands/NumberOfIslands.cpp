class Solution {
public:

    // Step 1: 
    // (i) Create a global variable r and c to store the row and coloumns of the grid
    int r, c;
    // (ii) Create 2 arrays, dx and dy to store the co-ordinates of the neighbour of an element in gird
    int dx[4] = {0,0,1,-1}, dy[4] = {1,-1,0,0};



    // Step 4: Dfs traversal
    void dfs(vector<vector<char>>& grid, int i, int j){

        //(i) If coordinates are out of bound or not equal to 1, return
        if(i<0 or j<0 or i>=r or j>=c or grid[i][j] != '1')
            return;

        // (ii) Else, the element has value == 1, so inorder to mark it as visited, let us change its value to '2'.
        grid[i][j] = '2';

        // (iii) Check for all its 4 neighbours, by setting coordinates for the neigbours and by calling dfs on them
        for(int k = 0; k<4; k++){
            int ii = i + dx[k], jj = j + dy[k];
            dfs(grid, ii, jj);
        }
    }

    int numIslands(vector<vector<char>>& grid) {

        // Solving using DFS traversal:

        // Step 2: 
        //(i) Find out the rows and columns of the grid and store it in global variable r and c
        r = grid.size(), c = grid[0].size();
        // (ii) Create an integer count to store the no. of islands. Initially, set it to 0.
        int count = 0;
        

        // Step 3: For all the coordinates of the grid, if the coordinate has value '1'
        // (i) Apply dfs on that coordinate.

        // Basic and Underlying Thinking: 
        // On dfs call, for the element in grid having value == 1, firstly we shall mark it as visited. Then, we shall check its 
        // all 4 neighbours one by one, if they have a value == 1, if yes, we then check its neighbour. Hence DFS.
        // When we return back to our starting element, we have found all 1's adjacent to each other and hence an island. SO,
        // we shall increment the count.
     
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == '1'){// To make sure, none of the already visited(marked as '2' or elements with '0' do not get call)
                    dfs(grid, i, j);
                    count++;
                } 
                    
            }
        }


        // Step 5: return count
        return count;


    }
};
