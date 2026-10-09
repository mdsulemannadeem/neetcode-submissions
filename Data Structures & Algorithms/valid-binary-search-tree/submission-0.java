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
    public boolean isValidBST(TreeNode root) {
        // Use Long to handle Integer.MIN_VALUE and Integer.MAX_VALUE boundaries safely
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer low, Integer high) {
        // An empty tree/node is a valid BST
        if (node == null) {
            return true;
        }

        // Current node's value must be strictly greater than low (if low exists)
        if (low != null && node.val <= low) {
            return false;
        }

        // Current node's value must be strictly less than high (if high exists)
        if (high != null && node.val >= high) {
            return false;
        }

        // Recurse left: update the upper bound (high) to current node's value
        // Recurse right: update the lower bound (low) to current node's value
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}
