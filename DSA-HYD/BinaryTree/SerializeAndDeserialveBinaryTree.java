/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        StringBuilder sb = new StringBuilder();
        while(q.size() != 0){
            // int size = q.size();
            // while(size != 0){
            
                TreeNode rem = q.removeFirst();
               
                if(rem != null){
                     
                    sb.append(rem.val + " ");
                }else{
                    sb.append("# ");
                }
                if(rem != null){
                     q.addLast(rem.left);
                     q.addLast(rem.right);
                }
               // size--;
            //}
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String [] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int i = 1;
        //System.out.println(nodes.length);
        while(q.size() != 0){
            TreeNode rem = q.removeFirst();
            if(rem != null){
                TreeNode left = null;
                if(!nodes[i].equals("#")){
                    left = new TreeNode(Integer.parseInt(nodes[i]));
                }
                rem.left = left;
                q.addLast(left);
                i++;
                TreeNode right = null;
                 if(!nodes[i].equals("#")){
                    right = new TreeNode(Integer.parseInt(nodes[i]));
                }
                rem.right = right;
                q.addLast(right);
                i++;
            }
           
        }

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
