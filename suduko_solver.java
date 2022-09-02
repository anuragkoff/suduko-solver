public class suduko_solver {
    public boolean isSafe(char[][] board, int row, int col, int number){
        // row & col
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char)(number + '0')) {
                return false;
            }
            if (board[row][i] == (char)(number + '0')) {
                return false;
            }
        }
        int sr = (row/3) *3 ;
        int sc = (col/3) *3 ;
        for (int j = 0; j < sr; j++) {
            for (int k = 0; k < sc; k++) {
                if (board[j][k] == (char)(number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean helper(char[][] board,int row, int col) {
        if (row == board.length) {
            return true;
        }
        int nrow = 0;
        int ncol = 0;
        if (col != board.length-1) {
            nrow = row;
            ncol = col + 1;
        }else{
            nrow = row + 1;
            ncol = 0;
        }
        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }
        }else{
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
