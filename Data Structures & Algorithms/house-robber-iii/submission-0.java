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
        int[] result = robHelper(root);
return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode node) {
// Base case: if node is null, return [0, 0]
if (node == null) return new int[2];

int[] left = robHelper(node.left);
int[] right = robHelper(node.right);

// result[0]: rob this node
// Cannot rob children, so we take their 'not robbed' values
int rob = node.val + left[1] + right[1];

// result[1]: do not rob this node
// Can choose max of robbing or not robbing children
int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

return new int[]{rob, notRob};
}
}