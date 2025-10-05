// User function Template for Java

class Solution {
    int [][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int numberOfEnclaves(int[][] grid) {


        LinkedList<int[]> q = new LinkedList<>();
            
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 1){
                       int[] arr1 = new int[2];
                       arr1[0] = i;
                       arr1[1] = j;
                       q.addLast(arr1);
                    }
                }
            }
    
            while(q.size() > 0){
                int size = q.size();
                while(size-- != 0){
                    int [] arr = q.removeFirst();
                    int row = arr[0];
                    int col = arr[1];
                    if(grid[row][col] == -1){
                        continue;
                    }
                    grid[row][col] = -1;
                    for(int [] dir : dirs){
                        int nr = row + dir[0];
                        int nc = col + dir[1];
                        if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
                            int[] arr1 = new int[2];
                            arr1[0] = nr;
                            arr1[1] = nc;
                            q.addLast(arr1);
                        }
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 1){
                       count++;
                    }
                }
            }
            return count;
        
        
    }
}
