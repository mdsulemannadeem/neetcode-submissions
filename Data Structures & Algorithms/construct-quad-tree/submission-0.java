/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int r, int c, int length) {
        // Step 1: Check if all cells in the current sub-grid share the same value
        boolean isUniform = true;
        int firstVal = grid[r][c];

        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (grid[i][j] != firstVal) {
                    isUniform = false;
                    break;
                }
            }
            if (!isUniform) {
                break;
            }
        }

        // Step 2: If the region is uniform, construct a Leaf Node
        if (isUniform) {
            return new Node(firstVal == 1, true);
        }

        // Step 3: If mixed, divide into 4 equal quadrants and recurse
        int half = length / 2;

        Node topLeft = helper(grid, r, c, half);
        Node topRight = helper(grid, r, c + half, half);
        Node bottomLeft = helper(grid, r + half, c, half);
        Node bottomRight = helper(grid, r + half, c + half, half);

        // Assemble the parent internal node (val can be true/false arbitrarily)
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
