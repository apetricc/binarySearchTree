/**
 * Created by petriccione on 10/19/15.
 */

/**
 *  30 points: Implement another Java class named BinarySearchTree, based on a binary search tree from the
 slides / textbook. Your primary data field will be a BSTNode named root, to represent the root of the tree.
 It will also contain a data field named size to record the number of elements stored in the tree.

 **Insert should increment size, and delete should decrement size.**

 Implement a zero-parameter constructor to set the root to NULL, and size to 0.
 Implement all dynamic set operations as described in the slides/textbook: search, minimum, maximum,
 successor, predecessor, insert, and delete. In addition to the pseudocode, insert should also increment
 the size data field, and delete should decrement the size data field.
 You will need a private helper method named transplant, as in the slides/textbook.
 Implement traversal methods named preOrder, inOrder, and postOrder based on the three kinds of traversals
 discussed in the slides/textbook. "Visiting" a node means printing to standard output the key followed by
 1 blank space.
 Implement a getter method for size.
 */
public class BinarySearchTree {
	private BSTNode root;
	private int size;

 public BinarySearchTree() {
   root = null;
   size = 0;
 }

 /**
  * INSERT(T,z) // T is our BST, and z is the new node to go into T
  y = NULL // a “trailing pointer” to the parent of the current node x
  x = T.root
  while x != NULL  // move down the tree one level per iteration
	y = x
	if z.key < x.key  // BST property tells us to go left
	  x = x.left
	else x = x.right  // BST property tells us to to right
  z.p = y // Loop is done. Location found. Set parent handle of z.
  if y == NULL // if T was an empty BST, z is the new root of the tree
	T.root = z
  elseif z.key < y.key // z’s parent is y, so set child handle to z
	y.left = z        // z is a left child
  else y.right = z     // z is a right child

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
  * TRANSPLANT(T, u, v)
	if u.p == NULL   // if u was the old root, then v is the new root
	   T.root = v
  elseif u == u.p.left // if u was the left child of p,
	   u.p.left = v      // then v is the new left child of p
  else u.p.right = v   // else u was right child of p.
  if v != NULL
	   v.p = u.p         // set v’s parent to p, the old parent of u

  * */
 public void transplant(BSTNode u, BSTNode v) {
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
 * DELETE(T, z)
     if z.left == NULL // case 1: z’s left child is NULL
        TRANSPLANT(T, z, z.right)
     elseif z.right == NULL // case 2: z’s right child is NULL
        TRANSPLANT(T, z, z.left)
     else // case 3: z has both children
        y = MINIMUM(z.right) // find z’s successor y
        if y.p != z // case 3b: z’s successor is not its right child
             TRANSPLANT(T, y, y.right)
             y.right = z.right
             y.right.p = y
        TRANSPLANT(T, z, y) // case 3a, which is also step 2 of case 3b
        y.left = z.left
        y.left.p = y
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
       y.getP().setLeft(y);
       size--;
    }
 }

 /**
  * MAXIMUM(x)
      while x.right != NULL
         x = x.right
      return x

  */
 public BSTNode maximum(BSTNode x) {
    while (x.getRight() != null) {
       x = x.getRight();
    }
    return x;
 }
/**
 * MINIMUM(x)
     while x.left != NULL
        x = x.left
     return x
 */
public BSTNode minimum() {
    return minimum(root);
}
private BSTNode minimum(BSTNode node) {
    while (node.getLeft() != null) {
       node = node.getLeft();
    }
    return node;
 }

 /**
  * SEARCH(x, k) // x is the root node of our BST, k is the search key
    if x == NULL                   // base case: empty subtree
        return NULL
    if k == x.key                  // base case: key is at subtree root
        return x
    if k < x.key                   // recursive case: left subtree
        return SEARCH(x.left, k)
    else return SEARCH(x.right, k) // recursive case: right subtree
  */
 //might not need to pass it a node, set it to root
 public BSTNode search(int key) {
     return search(root, key);
 }

 private BSTNode search(BSTNode x, int key) {
        if (x == null) return null;
        if (key == x.getKey()) return x;
        if (key < x.getKey()) return search(x.getLeft(), key);
        else return search(x.getRight(), key);
    }//SEARCH
    //successor, predecessor
    /**
     * SUCCESSOR(x)
        if x.right != NULL // case 1: minimum of right subtree
            return MINIMUM(x.right)
        while x.p != NULL and x == x.p.right // case 2: find left parent
            x = x.p // go up to parent for next iteration
        return x.p
     */
    public BSTNode successor(BSTNode x) {
        if (x.getRight() != null) return minimum(x.getRight());
        while(x.getP() != null && x == x.getP().getRight()) x = x.getP();
        return x.getP();
    }
/**
 * PREDECESSOR(x)
    if x.left != NULL // case 1: maximum of left subtree
        return MAXIMUM(x.left)
    while x.p != NULL and x == x.p.left // case 2: find right parent
        x = x.p // go up to parent for next iteration
    return x.p
 */
    public BSTNode predecessor(BSTNode x) {
        if (x.getLeft() != null) return maximum(x.getLeft());
        while(x.getP() != null && x == x.getP().getLeft()) x = x.getP();
        return x.getP();
    }

    /**
     * Implement traversal methods named preOrder, inOrder, and postOrder based on the three kinds of traversals
     discussed in the slides/textbook. "Visiting" a node means printing to standard output the key followed by
     1 blank space.
     Implement a getter method for size.
     */
    public int getSize() {
        return size;
    }
    public void preOrder() {
      preOrder(root);
    }
    private void preOrder(BSTNode node) {
        if (node != null) {
           System.out.print(node.toString() + " ");
           preOrder(node.getLeft());
           preOrder(node.getRight());
        }
    }
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(BSTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.toString() + " ");
            inOrder(node.getRight());
        }
    }
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(BSTNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.toString() + " ");
        }
    }
}
