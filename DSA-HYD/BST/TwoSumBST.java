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
    // O(n)
    // O(n)
    HashSet<Integer> set= new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        int conuterPart = k - root.val;
        if(set.contains(conuterPart)){
            return true;
        }
        set.add(root.val);
        boolean left = findTarget(root.left, k);
        if(left == true){
            return true;
        }
        boolean right = findTarget(root.right, k);
        if(right == true){
            return true;
        }
        return false;
    }
}
