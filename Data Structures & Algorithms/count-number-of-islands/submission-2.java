class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public void BFS(int i, int j, int[][]visitor, char[][]grid ){
        visitor[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            queue.poll();
            int [] dRow = {1,0,-1,0};
            int [] dCol = {0,-1,0,1};
            for(int k=0;k<4;k++){
                int nRow = dRow[k] + row;
                int nCol = dCol[k] + col;
                if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[nRow][nCol]=='1' && visitor[nRow][nCol] == 0){
                    visitor[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol));
                }

            }

        }

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visitor = new int[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && visitor[i][j] == 0){
                    count++;
                    BFS(i, j, visitor,grid);
                }
            }

        }

        return count;
    }
}
