import java.io.*;
import java.util.*;

class Solution {

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int src, int par, boolean [] vis){
        if(vis[src] == true){
            return true;
        }
        vis[src] = true;
        List<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs){
            if(nbr != par){
                boolean res = isCycle(graph, nbr, src, vis);
                if(res){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                boolean res  = isCycle(adj, i, -1, vis);
                if(res){
                    return res;
                }
            }
            
        }

        return false;
       
    }
}

public class Main{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
