class Solution {
    public boolean exist(char[][] board, String word) {
        int index = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(DFS(i,j,board, word, index)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean DFS(int row, int col, char[][] board, String word, int index){
        if(index == word.length()){
            return true;
        }
        if(row<0 || row>= board.length|| 
           col<0 || col>= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(index)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean result = DFS(row+1, col, board, word, index+1) ||
        DFS(row-1, col, board, word, index+1) ||
        DFS(row, col+1, board, word, index+1) ||
        DFS(row, col-1, board, word, index+1) ;

        board[row][col] = temp;
        return result;

    }
}
