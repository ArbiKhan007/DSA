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

    TreeNode fn;
    TreeNode sn;
    TreeNode py;
    TreeNode curr;

    public void inorderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inorderTraversal(node.left);
        // Inorder 
        curr = node;
        if(py != null){
            if(py.val > curr.val){
                if(fn == null){
                    fn = py;
                    sn = curr;
                }else{
                    sn = curr;
                }
            }
        }
        py = curr;
        inorderTraversal(node.right);
    }
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = fn.val;
        fn.val = sn.val;
        sn.val = temp;
    }
}
