class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        int [] indegree = new int[n];
        for(int [] p : pre){
            int a = p[0];
            int b = p[1];
            graph[b].add(a);
            indegree[a]++;
        }

        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 0;  i < n; i++){
            if(indegree[i] == 0){
                q.addLast(i);
            }
        }

        int count = 0;
        while(q.size() > 0){
            int rem = q.removeFirst();
            count++;
            for(int nbr : graph[rem]){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.addLast(nbr);
                }
            }
        }


        return count==n;
    }
}
