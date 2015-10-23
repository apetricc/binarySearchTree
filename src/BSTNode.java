/**
 * Andrew Petriccione Csci 333 Fall 2015 Professor Whitley
 * Assignment: Binary Search Trees
 * The point of this assignment is to implement a binary search tree
 * and the sorting algorithm we discussed for it.
 */

/**
 * The BSTNode class represents one node of a binary search tree. It has data fields for
 * the parent, left child, right child, and the key.
 */
public class BSTNode {
    BSTNode p, left, right;
    int key;

    /**
     * The BSTNode constructor creates and empty node of a binary search tree with all handles set to null.
     *
     * @param key The key for the node being created.
     */
    public BSTNode(int key) {
        this.key = key;
        p = null;
        left = null;
        right = null;
    }

    /**
     * getP gets the parent of the node it is called on.
     *
     * @return the parent node.
     */
    public BSTNode getP() {
        return p;
    }

    /**
     * setP sets the parent node of the node it is passed.
     *
     * @param p The node to set the parent of.
     */
    public void setP(BSTNode p) {
        this.p = p;
    }

    /**
     * getLeft gets the left child node of the node it is called on.
     *
     * @return the left child node.
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * setLeft sets the left child node of the node it is passed.
     *
     * @param left the node to set the left child of.
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * getRight gets the right child of the node it is called on
     *
     * @return the right child node of the node that is having getRight
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * setRight sets the right child of the node it is called on
     *
     * @param right the node that is being set to be the right child
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }

    /**
     * getKey returns the key of the selected node
     *
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * toString returns a String with the node's key in it.
     *
     * @return the String that can be printed.
     */
    @Override
    public String toString() {
        return "" + key;
    }
}
