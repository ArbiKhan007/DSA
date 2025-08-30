class Solution {

    public boolean isValid(char[][] board, int row, int col, char ch){
        for(int c = 0; c < board[0].length; c++){
            if(board[row][c] == ch){
                return false;
            }
        }

        for(int r = 0; r < board.length; r++){
            if(board[r][col] == ch){
                return false;
            }
        }

        int stRow = (row/3)*3;
        int stCol = (col/3)*3;

        for(int r = stRow; r < stRow + 3; r++){
            for(int c = stCol; c < stCol + 3; c++){
                if(board[r][c] == ch){
                    return false;
                }
            }
        }

        return true;


    }

    public boolean traversal(char[][] board, int row, int col){

        if(row == board.length){
            return true;
        }

        if(board[row][col] == '.'){
            for(char ch = '1'; ch <= '9'; ch++){
                // ch = '3'
                if(isValid(board, row, col, ch) == true){
                    board[row][col] = ch;
                    int nrow = col == board.length - 1 ? row + 1: row; // 0
                    int ncol = col == board.length - 1 ? 0 : col + 1; // 8
                    
                    boolean resp = traversal(board, nrow, ncol);
                    if(resp){
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }else{
            int nrow = col == board.length - 1 ? row + 1: row; // 0
            int ncol = col == board.length - 1 ? 0 : col + 1; // 8   
            boolean resp = traversal(board, nrow, ncol);
            if(resp){
                return true;
            }
        }
        return false;
    }


    public void solveSudoku(char[][] board) {
        traversal(board, 0, 0 );
    }
}
