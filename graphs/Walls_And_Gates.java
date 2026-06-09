class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Queue for BFS traversal, storing coordinates as [row, col]
        Deque<int[]> queue = new LinkedList<>();


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[] {row, col});
                }
            }
        }

        int distance = 0;
        int[] dir = {-1,0,1,0,-1};

        while(queue.size()>0){
            distance++;

            int level = queue.size();

            for(int i=0;i<level;i++){
                
                int[] ccell = queue.poll();
                int crow  = ccell[0];
                int ccol = ccell[1];

                for(int j=0;j<4;j++){

                    int nrow = crow + dir[j];
                    int ncol = ccol + dir[j+1];

                    if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && grid[nrow][ncol]==Integer.MAX_VALUE){
                        grid[nrow][ncol] = distance ;
                        queue.offer(new int[] {nrow,ncol});
                    }

                }


            }
        }


    }
}
