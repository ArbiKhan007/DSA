// User function Template for Java

class Solution {
    
    
     int [][] dirs = {{-1, 0, 1}, {0, 1, 2}, {1, 0, 3}, {0, -1, 4}};

  public  void dfs(int sr, int sc, int [][] grid, StringBuilder psf){
    grid[sr][sc] = -1;
    for(int [] dir : dirs){
      int nr = sr + dir[0];
      int nc = sc + dir[1];
      if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1){
        psf.append(dir[2]);
        dfs(nr, nc , grid, psf);
      }
    }
    
    psf.append("#");
  }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
              StringBuilder sb = new StringBuilder();
              dfs(i, j , grid, sb);
              String path = sb.toString();
              set.add(path);
            }
          }
        }
    return set.size();
        
    }
}
