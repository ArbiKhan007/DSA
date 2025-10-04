class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        LinkedList<int[]> q = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    int [] arr = {i, j, 0};
                    q.addLast(arr);
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(q.size() > 0){
            int size = q.size();
            while(size-- != 0){
                int [] rem = q.removeFirst();
                int row = rem[0];
                int col = rem[1];
                int dist = rem[2];
                if(mat[row][col] > 0){
                    continue;
                }
                mat[row][col] = dist;
                for(int [] dir : dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && mat[nr][nc] == -1){
                        int [] arr = {nr, nc, dist + 1};
                        q.addLast(arr);
                    }
                }
            }
        }

        return mat;

    }
}
