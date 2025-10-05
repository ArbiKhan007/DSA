import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {

    boolean dfs( ArrayList<Integer> [] graph,int stp,  int src, boolean [] vis, int count, String psf, int n){
        vis[src] = true;
        psf += src;
        count++;
        if(count == n){
            System.out.println(psf);

            // apply loop 
            return true;
        }
        for(int nbr : graph[src]){
            if(vis[nbr] == false){
               boolean res = dfs(graph, nbr, vis,count, psf, n); 
               if(res){
                return res;
               }
            }
        }
        vis[src] = false;
        return false;
    }
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        ArrayList<Integer> [] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(ArrayList<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs
    }
}
