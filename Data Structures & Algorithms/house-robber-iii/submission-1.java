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
    public int rob(TreeNode root) {
        int[] result = travel(root);
        return Math.max(result[0],result[1]);
    }
    private int [] travel(TreeNode node){
        if(node == null) return new int[2];

        int [] left = travel(node.left);
        int [] right = travel(node.right);
        int [] option = new int [2];

        option[0] = node.val + left[1] + right[1];
        option[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return option;
    }
}