/**
 * The Node for an Integer Binary Tree
 *
 * @author: Surya De Datta
 * @version: 12/12/24
 */

public class BSTNode {
    private BSTNode left;
    private BSTNode right;
    private int val;

    public BSTNode(int val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    /** Getters and Setters **/
    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public String toString() {
        return Integer.toString(this.val);
    }

    public boolean equals(BSTNode other) {
        return this.val == other.val;
    }
}
