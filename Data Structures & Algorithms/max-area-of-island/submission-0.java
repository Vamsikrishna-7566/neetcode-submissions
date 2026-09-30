class Solution {
    public int DFS(int row, int col, int[][] grid, int[][] visitor){
        if(row<0 || row>= grid.length || col<0 || col>=grid[0].length 
        || grid[row][col] == 0 || visitor[row][col] == 1){
            return 0;
        }

        visitor[row][col] = 1;
        int area = 1;
        area+= DFS( row+1, col, grid, visitor);
        area+= DFS( row-1, col, grid, visitor);
        area+= DFS( row, col+1, grid, visitor);
        area+= DFS( row, col-1, grid, visitor);

        return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visitor = new int[n][m];
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && visitor[i][j] == 0){
                    int area = DFS(i, j, grid, visitor);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
