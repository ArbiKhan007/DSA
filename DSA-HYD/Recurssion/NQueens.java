class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        int [][] board = new int[n + 1][n + 1];
        placeQueens(board, 1, n);

        return ans;

    }

    public boolean isSafe(int row, int col, int [][] board){
        for(int r = row; r >= 1; r--){
            if(board[r][col] == 1){
                return false;
            }
        }

        for(int r = row, c = col; r >= 1 && c >= 1; r--, c--){
            if(board[r][c] == 1){
                return false;
            }
        }

        for(int r = row, c = col; r >= 1 && c <= board.length - 1; r--, c++){
            if(board[r][c] == 1){
                return false;
            }
        }

        return true;
    }

    public void placeQueens(int [][] board, int q, int n){
        if(q == n + 1){
            List<String> config = new ArrayList<>();
            for(int i = 1; i <= n; i++){
                String str = "";
                for(int j = 1; j <= n; j++){
                    if(board[i][j] == 0){
                        str += ".";
                    }else{
                        str += "Q";
                    }
                }
                config.add(str);
            }
            ans.add(config);
            return;
        }
        for(int i = 1; i <= n; i++){
            if(isSafe(q, i, board) == true){
                board[q][i] = 1;
                placeQueens(board, q + 1, n);
                board[q][i] = 0;
            }
        }
    }
}
