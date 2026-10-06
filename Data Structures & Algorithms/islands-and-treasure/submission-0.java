class Pair{
    int row;
    int col;
    int val;

    public Pair(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visitor = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                }
            }
        }
        BFS(grid, queue);
        
    }

    public void BFS(int[][] grid, Queue<Pair> queue){
        while(!queue.isEmpty()){

            Pair pair = queue.poll();
            int row = pair.row;
            int col = pair.col;
            int count = pair.val;


            int []dRow = {-1,0,1,0};
            int []dCol = {0,1,0,-1};
            for(int i=0;i<4;i++){
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow>=0 && nRow < grid.length && nCol >=0 && nCol <
                grid[0].length && grid[nRow][nCol] == 2147483647
                ){
                    grid[nRow][nCol] = count + 1;
                    queue.add(new Pair(nRow, nCol, count + 1));

                }

            }
        }


    }


}
