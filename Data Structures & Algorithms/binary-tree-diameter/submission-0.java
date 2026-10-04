
class Solution {
    int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
                if (root == null) {
                            return 0;
                                    }

                                            int left = height(root.left);
                                                    int right = height(root.right);

                                                            diameter = Math.max(diameter, left + right);

                                                                    diameterOfBinaryTree(root.left);
                                                                            diameterOfBinaryTree(root.right);

                                                                                    return diameter;
                                                                                        }

                                                                                            private int height(TreeNode root) {
                                                                                                    if (root == null) return 0;

                                                                                                            return 1 + Math.max(height(root.left), height(root.right));
                                                                                                                }
                                                                                                                }
                                                                                                                
