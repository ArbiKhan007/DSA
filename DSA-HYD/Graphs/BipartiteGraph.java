class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       ArrayList<Integer> [] graph = new ArrayList[n+1];
       for(int i = 0; i<dislikes.length; i++){
           int a = dislikes[i][0];
           int b = dislikes[i][1];
           if(graph[a] == null){
               ArrayList<Integer> li = new ArrayList<>();
               li.add(b);
               graph[a] = li;
           }else{
               graph[a].add(b);
           }
       }
        for(int i = 1; i<=n; i++){
            
        
        LinkedList<Integer> q = new LinkedList<>();
        int [] vis = new int[n+1];
        Arrays.fill(vis,-1);
        q.addLast(i);
        vis[i] = 1;
        while(q.size() != 0){
            int size = q.size();
            while(size != 0){
                int rem = q.removeFirst();
                if(graph[rem] == null){
                    size--;
                    continue;
                }
                ArrayList<Integer> nbrs = graph[rem];
                for(int nbr : nbrs){
                    if(vis[nbr] == -1){
                        q.addLast(nbr);
                        if(vis[rem] == 1){
                            vis[nbr] = 2;
                        }else{
                            vis[nbr] = 1;
                        }
                    }else{
                        if(vis[rem] == vis[nbr]){
                            return false;
                        }
                    }
                }
                size--;
            }
        }
        }
        return true;
        
      
    }
}
