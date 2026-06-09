class Solution {

    int rows;
    int cols;
    public int numIslands(char[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int count =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(int row,int col,char[][]grid){
        grid[row][col]='0';
        int[] directions = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
          
            // Check if adjacent cell is within bounds and is unvisited land
            if (newRow >= 0 && newRow < rows && 
                newCol >= 0 && newCol < cols && 
                grid[newRow][newCol] == '1') {
                // Recursively explore the adjacent land cell
                dfs(newRow, newCol,grid);
            }
        }
        return;
    }
}
