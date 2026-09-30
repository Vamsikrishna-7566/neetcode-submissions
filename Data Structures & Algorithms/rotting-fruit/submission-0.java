class Pair{
    int row;
    int col;
    int sec;

    public Pair(int row, int col, int sec){
        this.row = row;
        this.col = col;
        this.sec = sec;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int freshOranges =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    visited[i][j] = 1;
                    queue.add(new Pair(i,j,0));
                }
                else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        int count = 0;
        int maxSeconds = 0;
        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int sec = queue.peek().sec;
            maxSeconds =Math.max(maxSeconds, sec);
            queue.poll();
            int [] dRow = {0,1,0,-1};
            int [] dCol = {-1,0,1,0};
            for(int i=0;i<4;i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if(nRow>=0 && nRow< n && nCol >=0 && nCol<m && grid[nRow][nCol] == 1 
                  && visited[nRow][nCol] ==0){
                    visited[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol, sec+1));
                    count++;
                }

            }
        }
        if(count != freshOranges) return -1;
        return maxSeconds;
    }
}
