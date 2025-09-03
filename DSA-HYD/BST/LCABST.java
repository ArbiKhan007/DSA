/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // Expectation of this function is to return lca of both p and q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            // Both P and Q are lying in the left 
            TreeNode lca = lowestCommonAncestor(root.left, p, q);
            return lca;
        }else if(root.val < p.val && root.val < q.val){
            TreeNode lca = lowestCommonAncestor(root.right, p, q);
            return lca;
        }else{
            return root;
        }
    }
}
