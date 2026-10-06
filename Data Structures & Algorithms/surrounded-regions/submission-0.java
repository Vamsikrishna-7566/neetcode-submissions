class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        //Iterating through columns and fixing the rows.
        for(int col=0;col<m;col++){
            if(board[0][col] == 'O' && visited[0][col]== 0){
                DFS(0, col, board, visited);
            }
            if(board[n-1][col] == 'O' && visited[n-1][col] == 0){
                DFS(n-1, col, board, visited);
            }
        }

        //Iterating through rows and fixing the columns.
        for(int row=0;row<n;row++){
            if(board[row][0] == 'O' && visited[row][0] == 0){
                DFS(row, 0, board, visited);
            }
            if(board[row][m-1] == 'O' && visited[row][m-1] == 0){
                DFS(row, m-1, board, visited);
            }
        }  

        for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){

        if(board[i][j] == 'O'){
            board[i][j] = 'X';
        }
        else if(board[i][j] == 'S'){
            board[i][j] = 'O';
        }
    }
}    
    }

    public void DFS(int row, int col, char[][] board, int[][] visited){
        int n = board.length;
        int m = board[0].length;

        if(row<0 || row>=n || col<0 || col>=m || board[row][col]== 'X' || visited[row][col] == 1){
            return;
        }


        

        if( board[row][col] == 'O' && visited[row][col] == 0){
            visited[row][col] = 1;
            board[row][col] = 'S';
        }


        DFS(row+1, col, board, visited);
        DFS(row-1, col, board, visited);
        DFS(row, col+1, board, visited);
        DFS(row, col-1, board, visited);

    }
}
