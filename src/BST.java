import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * Surya De Datta
 * 12/12/24
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return searchHelper(root, val);
    }
    public boolean searchHelper(BSTNode node, int value)
    {
        // Makes sure the tree is not empty before looking for a certain node
        if(node == null)
        {
            return false;
        }
        // Searches the value to the left if the value to look for is less than the current nodes' value
        if(value < node.getVal())
        {
            return searchHelper(node.getLeft(), value);
        }
        // Searches the value to the right if the value to look for is more than the current nodes' value
        if(value > node.getVal())
        {
            return searchHelper(node.getRight(), value);
        }
        // Returns true if the value is found at the current node
        else
        {
            return true;
        }

    }

    /**
     * Returns an ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        inorderHelper(root, nodes);
        // Returns the nodes in inorder format
       return nodes;

    }
    public void inorderHelper(BSTNode node, ArrayList<BSTNode> theNodes)
    {
        // Continues until it visits a node that doesn't exist
        if(node != null)
        {
            // Visits each node from Left → Root → Right
            inorderHelper(node.getLeft(), theNodes);
            theNodes.add(node);
            inorderHelper(node.getRight(), theNodes);
        }
    }

    /**
     * Returns an ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        preOrderHelper(root, nodes);
        // Returns the nodes in preorder format
        return nodes;
    }
    public void preOrderHelper(BSTNode node, ArrayList<BSTNode> theNodes)
    {
        // Continues until it visits a node that doesn't exist
        if(node != null)
        {
            // Visits each node from Root → Left → Right
            theNodes.add(node);
            preOrderHelper(node.getLeft(), theNodes);
            preOrderHelper(node.getRight(), theNodes);
        }
    }

    /**
     * Returns an ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> nodes = new ArrayList<>();
        postOrderHelper(root, nodes);
        // Returns the nodes in postorder format
        return nodes;
    }
    public void postOrderHelper(BSTNode node, ArrayList<BSTNode> theNodes)
    {
        // Continues until it visits a node that doesn't exist
        if(node != null)
        {
            // Visits each node from Left → Root → Right
            inorderHelper(node.getLeft(), theNodes);
            inorderHelper(node.getRight(), theNodes);
            theNodes.add(node);
        }
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // Base case to ensure a node with that value doesn't exist already
        if(!search(val))
        {
            insertHelper(root, val);
        }
    }
    public void insertHelper(BSTNode node, int value)
    {
        // Ensures the tree is not empty
        if(node == null)
        {
            node = new BSTNode(value);
        }
        // Checks if the new node should be placed to the right or left of the current node
        if(value < node.getVal())
        {
            // Places the node to the left of the current one if the left has no node at the moment
            if(node.getLeft() == null) {
                node.setLeft(new BSTNode(value));
            }
            // Keeps checking nodes to the left as long as the value is less than the current node
            else
            {
                insertHelper(node.getLeft(), value);
            }
        }
        if(value > node.getVal())
        {
            // Places the node to the right of the current one if the right has no node at the moment
            if(node.getRight() == null) {
                node.setRight(new BSTNode(value));
            }
            // Keeps checking nodes to the right as long as the value is less than the current node
            else
            {
                insertHelper(node.getRight(), value);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help test code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
