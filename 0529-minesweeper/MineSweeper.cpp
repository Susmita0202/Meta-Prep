
class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') board[row][col] = 'X';
        else reveal(row, col, board);
        return board;
    }

    void reveal(int i, int j, vector<vector<char>>& board) {
        if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() || board[i][j] != 'E') return;
        int neigh = numbermines(i, j, board, 0);
        if (neigh > 0) {
            board[i][j] = neigh + '0';
        } else {
            board[i][j] = 'B';
            reveal(i + 1, j, board);
            reveal(i, j + 1, board);
            reveal(i - 1, j, board);
            reveal(i, j - 1, board);
            reveal(i + 1, j + 1, board);
            reveal(i - 1, j - 1, board);
            reveal(i + 1, j - 1, board);
            reveal(i - 1, j + 1, board);
        }
    }

    int numbermines(int row, int col, vector<vector<char>>& board, int c) {
        if (row - 1 >= 0 && board[row - 1][col] == 'M') c++;
        if (row + 1 < board.size() && board[row + 1][col] == 'M') c++;
        if (col - 1 >= 0 && board[row][col - 1] == 'M') c++;
        if (col + 1 < board[0].size() && board[row][col + 1] == 'M') c++;
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1] == 'M') c++;
        if (row - 1 >= 0 && col + 1 < board[0].size() && board[row - 1][col + 1] == 'M') c++;
        if (row + 1 < board.size() && col - 1 >= 0 && board[row + 1][col - 1] == 'M') c++;
        if (row + 1 < board.size() && col + 1 < board[0].size() && board[row + 1][col + 1] == 'M') c++;
        return c;
    }
};
