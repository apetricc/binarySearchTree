/**
 * Andrew Petriccione Csci 333 Fall 2015 Professor Whitley
 * Assignment: Binary Search Trees
 * The point of this assignment is to implement a binary search tree
 * and the sorting algorithm we discussed for it.
 */
/**
 * The BinarySearchTree class uses BSTNode objects to create
 * a binary search tree and maintains the binary tree property while
 * allowing for some standard operations on the tree and its nodes.
 */
public class BinarySearchTree {
	private BSTNode root;
	private int size;
    /**
     * The constructor for the BinarySearchTree creates a BinarySearchTree
     * with a null root and size 0.
     */
 public BinarySearchTree() {
   root = null;
   size = 0;
 }

    /**
     * insert inserts a node into the tree.
     * @param z the node to be inserted
     */
 public void insert(BSTNode z) {
   BSTNode y = null;
   BSTNode x = root;
   while (x != null) {
	 y = x;
	 if (z.getKey() < x.getKey()) x = x.getLeft();
	 else x = x.getRight();
   }
   z.setP(y);
   if (y == null) {
	root = z;
	size++;
   }
   else if (z.getKey() < y.getKey()) {
	y.setLeft(z);
	size++;
   }
   else{
	y.setRight(z);
	size++;
   }
 }//INSERT
    /**
     * transplant moves a node from one location in the tree to another
     * as part of other operations--this is a helper method.
     * @param u the first node location
     * @param v the second node location
     */
 private void transplant(BSTNode u, BSTNode v) {
    if (u.getP() == null) {
       root = v;
    }
    else if (u == u.getP().getLeft()) {
       u.getP().setLeft(v);
    }
    else u.getP().setRight(v);
    if (v != null) {
      v.setP(u.getP());
    }
 }//TRANSPLANT

    /**
     * delete removes a node from the binary search tree, maintaining the
     * binary search tree property, and decreasing the size of the tree.
     * @param z The node to be deleted.
     */
 public void delete(BSTNode z) {
    if (z.getLeft() == null) {
       transplant(z, z.getRight());
        size--;
   }
    else if (z.getRight() == null) {
       transplant(z, z.getLeft());
       size--;
    }
    else {
       BSTNode y = minimum(z.getRight());
       if (y.getP() != z) {
          transplant(y, y.getRight());
          y.setRight(z.getRight());
          y.getP().setRight(y);
          size--;
       }
       transplant(z, y);
       y.setLeft(z.getLeft());
       //y.getP().setLeft(y);
        y.getLeft().setP(y);
       size--;
    }
 }

    /**
     * maximum is a public method that returns the node with the maximum key value in the binary search tree.
     * @return a call to the private maximum method called on the root.
     */
 public BSTNode maximum() {
     return maximum(root);
 }

    /**
     * maximum is the private helper method to the public maximum method
     * that returns the node with the maximum key value in the binary search tree--it is
     * called on the root of a binary search tree.
     * @param node The node to begin looking for the maximum.
     * @return the node with the maximum key.
     */
 private BSTNode maximum(BSTNode node) {
    while (node.getRight() != null) {
       node = node.getRight();
    }
    return node;
 }
    /**
     * minimum is a public method that returns the node with the minimum key value in a binary search tree.
     * @return a call to the private minimum method called on the root.
     */
public BSTNode minimum() {
    return minimum(root);
}
    /**
     * minimum is the private helper method to the public minumum method
     * that returns the node with the minimum key value in the binary
     * search tree--it is called on the root of a binary search tree.
     * @param node The node to begin looking for the minimum.
     * @return the node with the minimum key.
     */
    private BSTNode minimum(BSTNode node) {
    while (node.getLeft() != null) {
       node = node.getLeft();
    }
    return node;
 }

    /**
     * search is a public method that looks for a node with the given key.
     * @param key The key to search for.
     * @return a call to the private search method, called on the root & the key given.
     */
 public BSTNode search(int key) {
     return search(root, key);
 }

    /**
     * search is the private helper method to the public search method that
     * looks for a node with the given key--it is called on the root of a binary
     * search tree by the public method.
     * @param x The node to begin searching the tree at.
     * @param key The key to search for.
     * @return the node with the key being searched for, or else null.
     */
 private BSTNode search(BSTNode x, int key) {
        if (x == null) return null;
        if (key == x.getKey()) return x;
        if (key < x.getKey()) return search(x.getLeft(), key);
        else return search(x.getRight(), key);
    }//SEARCH

    /**
     * successor returns the successor (node with next largest key) of the
     * node it is called on.
     * @param x The node to find the successor of.
     * @return The node that is the successor.
     */
    public BSTNode successor(BSTNode x) {
        if (x.getRight() != null) return minimum(x.getRight());
        while(x.getP() != null && x == x.getP().getRight()) x = x.getP();
        return x.getP();
    }

    /**
     * predecessor returns the predecessor (node with next smallest key) of the
     * node it is called on.
     * @param x The node to find the predecessor of.
     * @return The node that is the predecessor.
     */
    public BSTNode predecessor(BSTNode x) {
        if (x.getLeft() != null) return maximum(x.getLeft());
        while(x.getP() != null && x == x.getP().getLeft()) x = x.getP();
        return x.getP();
    }
    /**
     * getSize returns an integer that is the number of nodes in the binary search tree.
     * @return the size of the binary search tree
     */
    public int getSize() {
        return size;
    }

    /**
     * preOrder is a public method that calls the private preOrder method
     * which returns the nodes of the binary search tree
     * in the order of a pre-order traversal of the tree.
     */
    public void preOrder() {
      preOrder(root);
    }

    /**
     * preOrder is the private helper method to the public
     * preOrder method which
     * returns the nodes in the binary search tree in the order of
     * a pre-order traversal of the tree.
     * @param node The node to begin the traversal of the tree on.
     */
    private void preOrder(BSTNode node) {
        if (node != null) {
           System.out.print(node.toString() + " ");
           preOrder(node.getLeft());
           preOrder(node.getRight());
        }
    }

    /**
     * inOrder is a public method that calls the private inOrder method
     * which returns the nodes in the binary search tree in the order of
     * an in-order traversal of the tree.
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * inOrder is the private helper method to the public inOrder method
     * that returns the nodes in the binary search tree in the order of
     * an in-order traversal of the tree.
     * @param node The node to begin the traversal of the tree on.
     */
    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.toString() + " ");
            inOrder(node.getRight());
        }
    }
    /**
     * postOrder is a method that calls the private postOrder method on the
     * root of the binary search tree which returns the nodes in the binary
     * search tree in the order of a post-order traversal of the tree.
     */
    public void postOrder() {
        postOrder(root);
    }
    /**
     * postOrder is a private helper method to the public postOrder method
     * which returns the nodes in the binary search tree in the order of
     * a post-order traversal of the tree.
     * @param node The node to begin the traversal of the tree on.
     */
    private void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.toString() + " ");
        }
    }
}
