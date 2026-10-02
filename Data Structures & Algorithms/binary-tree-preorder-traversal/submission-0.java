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
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
            // Base case: if the tree is empty, return the empty list
                    if (root == null) {
                                return result;
                                        }
                                                
                                                        helper(root, result);
                                                                return result;
                                                                    }
                                                                        
                                                                            private void helper(TreeNode node, List<Integer> result) {
                                                                                    if (node == null) {
                                                                                                return;
                                                                                                        }
                                                                                                                
                                                                  result.add(node.val);                                                      helper(node.left, result);    // 1. Go Left
                                                                                                                                
                                                                                                                                        helper(node.right, result);   // 3. Go Right
                                                                                                                                            }
                                                                                                                                            }