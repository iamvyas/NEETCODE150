class Solution {
    int rows;
    int cols;
    int tempcount=0;
    int largest=0;
    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid);
                    if(tempcount>largest){
                        largest=tempcount;
                        System.out.println("found one");
                    }
                    tempcount =0;
                }
            }
        }

        return largest;
        
    }

    public void dfs(int row ,int col ,int grid[][] ){
        grid[row][col] = '0';
        tempcount++;
      
        // Direction vectors for exploring 4 adjacent cells (up, right, down, left)
        // Using pairs: (-1,0), (0,1), (1,0), (0,-1)
        int[] directions = {-1, 0, 1, 0, -1};
      
        // Explore all 4 adjacent cells
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[i];
            int newCol = col + directions[i + 1];
          
            // Check if adjacent cell is within bounds and is unvisited land
            if (newRow >= 0 && newRow < rows && 
                newCol >= 0 && newCol < cols && 
                grid[newRow][newCol] == 1) {
                // Recursively explore the adjacent land cell
                dfs(newRow, newCol,grid);
            }
        }

    }
}
