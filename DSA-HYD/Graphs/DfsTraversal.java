import java.util.*;

class Solution {
    public static void DFSTraversal(List<List<Integer>> graph, int src, boolean [] vis) {
        vis[src] = true;
        System.out.print(src + " ");
        List<Integer> nbrs = graph.get(src);
        Collections.sort(nbrs);
        for(int nbr : nbrs){
            if(vis[nbr] == false){
                DFSTraversal(graph, nbr, vis);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int tVtx = scn.nextInt();
       int tEdges = scn.nextInt();
       List<List<Integer>> graph = new ArrayList<>();
       for(int i = 0; i <= tVtx; i++){
        graph.add(new ArrayList<>());
       }
       boolean [] vis = new boolean[tVtx + 1];
       for(int i = 0; i < tEdges; i++){
        int u = scn.nextInt();
        int v = scn.nextInt();
        graph.get(u).add(v);
        graph.get(v).add(u);
       }

       Solution Solution = new Solution();
       Solution.DFSTraversal(graph, 0,vis); 
       

    }
}
