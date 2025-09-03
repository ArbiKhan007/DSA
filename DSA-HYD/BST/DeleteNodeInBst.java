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
    // Expectation : It will search the key in the tree and will delete and will return the root of the bst 
    public TreeNode findMax(TreeNode leftNode){

        while(leftNode.right != null){
            leftNode = leftNode.right;
        }

        return leftNode;

    }
    public TreeNode delete(TreeNode curr, int key){
        if(curr == null){
            return null;
        }
        if(curr.val < key){
           curr.right = delete(curr.right, key);
           return curr;
        }else if(curr.val > key){
            curr.left = delete(curr.left, key);
            return curr;
        }else{
            // curr.val == key 
            // We will come into the else condition when curr node is equal to the key 
            // That means we need to delte curr node. 
            // We need to check for all the 4 cases 
            if(curr.left != null && curr.right != null){
                // We need to find left subtree maximum value 
                TreeNode maxNode = findMax(curr.left);
                int temp = curr.val;
                curr.val = maxNode.val;
                maxNode.val = temp;
                // AfteSwapping 
                // We will again call delete method for 
                curr.left =  delete(curr.left, key);
                return curr;
            }else if(curr.left != null){
                return curr.left;
            }else if(curr.right != null){
                return curr.right;
            }else{
                return null;
            }
        }
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
       return delete(root, key);
    }
}
