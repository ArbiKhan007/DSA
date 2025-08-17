/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode flatTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode lt = flatTree(root.left);
        TreeNode rt = flatTree(root.right);
        if(root.left == null && root.right == null){
            return root;
        }else if(root.left == null){
            return rt;
        }else if(root.right == null){
            root.right = root.left;
            root.left = null;
            return lt;
        }else{
            lt.right = root.right;
            root.right = root.left;
            root.left = null;
            return rt;
        }
    }
    public void flatten(TreeNode root) {
        flatTree(root);
    }
}
