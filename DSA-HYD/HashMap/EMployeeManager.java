import java.io.*;
import java.util.*;

class Solution {

    public int dfs(String manager, HashMap<String, List<String>> orgTree, int [] ans){
        List<String> emps = orgTree.get(manager);
        int count= 0;
       // System.out.println(emps);
       int idx = manager.charAt(0) - 'A';
       if(emps == null){
        ans[idx] = 0;
        return 1;
       }
        for(int i = 0; i < emps.size(); i++){
            String emp = emps.get(i);
            count += dfs(emp, orgTree, ans);
        }
        
        ans[idx] = count;
        return count + 1;
    }

    public void EmpUnderManager(Map<String, String> map)
	{
		HashMap<String, List<String>> orgTree = new HashMap<>();
        String ceo = "";
        for(String employee : map.keySet()){
            String manager = map.get(employee);
            if(manager.equals(employee)){
                ceo = employee;
            }else{
                if(orgTree.containsKey(manager)){
                    orgTree.get(manager).add(employee);
                }else{
                    List<String> emps = new ArrayList<>();
                    emps.add(employee);
                    orgTree.put(manager, emps);
                }
            }
        }

        //System.out.println(orgTree);
        int [] ans = new int[26];
        Arrays.fill(ans, -1);
        //System.out.println(ceo);
        dfs(ceo, orgTree, ans);

        for(int i = 0; i < ans.length; i++){
            if(ans[i] != -1){
                char ch= (char)(i + 'A');
                System.out.println(ch + " " + ans[i]);
            }
        }
	}

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}
