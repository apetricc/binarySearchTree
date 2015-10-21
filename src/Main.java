/**
 * Created by petriccione on 10/19/15.
 */

/**
 * 18 points: Create another class in the same package, with a method named bstSort, and a main method for
 testing bstSort and the BinarySearchTree class.
 The bstSort method should take an int array parameter, and print the elements of the array in sorted order
 by first inserting all the elements into a local BinarySearchTree, then performing an in-order traversal of the tree.
 In main, test your BinarySearchTree class and your bstSort method, by doing at least the following:
 Create a BinarySearchTree and insert at least 20 elements into it.
 Do pre- in- and post-order traversals of the tree, and also print its size.
 Print all elements of the tree by first using minimum, then invoking successor size-1 times in a loop.
 Print all elements of the tree by first using maximum, then invoking predecessor size-1 times in a loop.
 Search for at least 5 keys in the tree and 5 keys not in the tree, and print all inputs and results to the console.
 Delete a handful of elements from the tree, print its size again, then do another in-order traversal to print out the
 contents.
 Finally, invoke bstSort on at least 5 different arrays of different lengths with different values, and print the
 results to the console. The results of bstSort should always print in sorted order.
 You must implement your methods and classes described above from scratch, except you may use the following parts
 of the Java Standard Library:

 console I/O
 */
public class Main {
    public static void bstSort(int[] nums) {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < nums.length; i++) {
            tree.insert(new BSTNode(nums[i]));
        }
        tree.inOrder();
    }
    public static String arrayPrinter(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += "[" +arr[i] +"]";
        }
        return result;
    }

    public static void main(String[] args) {
        //BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {11, 4, 3, 5, 7, 9, 1};
        System.out.println("Here is the initial array: " + arrayPrinter(arr));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr);
        System.out.println();
        BinarySearchTree newTree = new BinarySearchTree();

        for (int i = 0; i < arr.length; i++) {
            newTree.insert(new BSTNode(arr[i]));

        }


        System.out.println("Here is the pre-order traversal: ");
        newTree.preOrder();
        System.out.println("\nHere is the in-order traversal: ");
        newTree.inOrder();
        System.out.println("\nHere is the post-order traversal: ");
        newTree.postOrder();
        System.out.println("\nThe size of the tree is: " + newTree.getSize());

    }//main


}
