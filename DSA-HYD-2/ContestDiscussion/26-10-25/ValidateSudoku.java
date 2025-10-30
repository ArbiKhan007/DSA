class Solution {
    public boolean validate(int row, int col, char [][] board){
        int n = board.length;
        for(int j = 0; j < n; j++){
            if(j == col){
                continue;
            }
            if(board[row][col] == board[row][j]){
                return false;
            }
        }

        for(int i = 0; i < n; i++){
            if(i == row){
                continue;
            }
            if(board[i][col] == board[row][col]){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(i == row && j == col){
                    continue;
                }
                if(board[i][j] == board[row][col]){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(validate(i, j , board) == false){
                    return false;
                }
            }
        }

        return true;

    }
}
