/**
 * Created by petriccione on 10/19/15.
 */

/**
 * You will be implementing a binary search tree as a Java class (with no balancing mechanism), and implement the
 * BST sort algorithm, in addition to testing it all in main.  All code should be written in Java using NetBeans.

 12 points: Implement a Java class named BSTNode, to represent one node of a binary search tree from the
 slides/textbook. The private data fields should be p, left, and right which are handles to other BSTNodes,
 as well as an int data field named key.


 Implement a constructor method with a key parameter. It will set p left and right to NULL, and key to the
 constructor parameter.
 Implement getter methods for key p left and right, to return the relevant data field.
 Implement setter methods for p left and right, to set the relevant data field to the parameter; copy the handle.




 30 points: Implement another Java class named BinarySearchTree, based on a binary search tree from the
 slides / textbook. Your primary data field will be a BSTNode named root, to represent the root of the tree.
 It will also contain a data field named size to record the number of elements stored in the tree. Insert should
 increment size, and delete should decrement size.
 Implement a zero-parameter constructor to set the root to NULL, and size to 0.
 Implement all dynamic set operations as described in the slides/textbook: search, minimum, maximum,
 successor, predecessor, insert, and delete. In addition to the pseudocode, insert should also increment
 the size data field, and delete should decrement the size data field.
 You will need a private helper method named transplant, as in the slides/textbook.
 Implement traversal methods named preOrder, inOrder, and postOrder based on the three kinds of traversals
 discussed in the slides/textbook. "Visiting" a node means printing to standard output the key followed by
 1 blank space. Implement a getter method for size.

 18 points: Create another class in the same package, with a method named bstSort, and a main method for
 testing bstSort and the BinarySearchTree class.
 The bstSort method should take an int array parameter, and print the elements of the array in sorted order
 by first inserting all the elements into a local BinarySearchTree, then performing an in-order traversal of the tree.
 In main, test your BinarySearchTree class and your bstSort method, by doing at least the following:
 Create a BinarySearchTree and insert at least 20 elements into it.
 Do pre- in- and post-order traversals of the tree, and also print its size.
 Print all elements of the tree by first using minimum, then invoking successor size-1 times in a loop.
 Print all elements of the tree by first using maximum, then invoking predecessor size-1 times in a loop.
 Search for at least 5 keys in the tree and 5 keys not in the tree, and print all inputs and results to the console.
 Delete a handful of elements from the tree, print its size again, then do another in-order traversal to print out
 the contents.
 Finally, invoke bstSort on at least 5 different arrays of different lengths with different values, and print the
 results to the console. The results of bstSort should always print in sorted order.
 You must implement your methods and classes described above from scratch, except you may use the following parts
 of the Java Standard Library:

 console I/O
 */

/**
 *  12 points: Implement a Java class named BSTNode, to represent one node of a binary search tree from the
 slides/textbook. The private data fields should be p, left, and right which are handles to other BSTNodes,
 as well as an int data field named key.


 Implement a constructor method with a key parameter. It will set p left and right to NULL, and key to the
 constructor parameter.
 Implement getter methods for key p left and right, to return the relevant data field.
 Implement setter methods for p left and right, to set the relevant data field to the parameter; copy the handle.
 */
public class BSTNode {
    BSTNode p,left,right;
    int key;
    public BSTNode(int key) {
        this.key = key;
        p = null;
        left = null;
        right = null;
    }

    public BSTNode getP() {
        return p;
    }

    public void setP(BSTNode p) {
        this.p = p;
    }

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

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
