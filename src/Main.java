/**
 * Created by petriccione on 10/19/15.
 */

/**
 * 18 points: Create another class in the same package, with a method named bstSort,
 * and a main method for testing bstSort and the BinarySearchTree class.
 The bstSort method should take an int array parameter, and print the elements of
 the array in sorted order by first inserting all the elements into a local
 BinarySearchTree, then performing an in-order traversal of the tree.
 In main, test your BinarySearchTree class and your bstSort method, by doing
 at least the following:
 Create a BinarySearchTree and insert at least 20 elements into it.
 Do pre- in- and post-order traversals of the tree, and also print its size.
 Print all elements of the tree by first using minimum, then invoking successor
 size-1 times in a loop.
 Print all elements of the tree by first using maximum, then invoking predecessor
 size-1 times in a loop.
 Search for at least 5 keys in the tree and 5 keys not in the tree, and print all
 inputs and results to the console.

 Delete a handful of elements from the tree, print its size again, then do another
 in-order traversal to print out the contents.
 Finally, invoke bstSort on at least 5 different arrays of different lengths
 with different values, and print the results to the console. The results of
 bstSort should always print in sorted order. You must implement your methods
 and classes described above from scratch, except you may use the following parts
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
        System.out.println();
    }
    public static String arrayPrinter(int[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += "[" +arr[i] +"]";
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {20,15,23,5,7,9,4,16,11,25,24,30,33,29,3,2,19,36,22,28};
        System.out.println("Here is the initial array: \n" + arrayPrinter(arr));

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



        System.out.println("The minimum of newTree is: " + newTree.minimum()
                + "\nHere is the minimum with all its successors: ");
        BSTNode min = newTree.minimum();
        for(int i = 0; i < newTree.getSize(); i++) {
            System.out.print(min + " ");
            min = newTree.successor(min);
        }

        System.out.println("\nThe maximum of newTree is: " + newTree.maximum()
                + "\nHere is the maximum with all its predecessors: ");
        BSTNode max = newTree.maximum();
        for (int i = 0; i < newTree.getSize(); i++) {
            System.out.print(max + " ");
            max = newTree.predecessor(max);
        }
/**
 * Search for at least 5 keys in the tree and 5 keys not in the tree, and print all
 inputs and results to the console.
 */
        System.out.print("\n\nSearching for 11.......found: ");
        System.out.println(newTree.search(11));
        System.out.print("Searching for 19.......found: ");
        System.out.println(newTree.search(19));
        System.out.print("Searching for 16.......found: ");
        System.out.println(newTree.search(16));
        System.out.print("Searching for 4........found: ");
        System.out.println(newTree.search(4));
        System.out.print("Searching for 20.......found: ");
        System.out.println(newTree.search(20));
        System.out.print("Searching for 0........found: ");
        System.out.println(newTree.search(0));
        System.out.print("Searching for 6........found: ");
        System.out.println(newTree.search(6));
        System.out.print("Searching for 40.......found: ");
        System.out.println(newTree.search(40));
        System.out.print("Searching for 50.......found: ");
        System.out.println(newTree.search(50));
        System.out.print("Searching for 60.......found: ");
        System.out.println(newTree.search(60));

/**
 Delete a handful of elements from the tree, print its size again, then do another
 in-order traversal to print out the contents.
 **/
        System.out.println("\nThe size of the tree is: " + newTree.getSize());
        newTree.delete(newTree.search(9));
        newTree.delete(newTree.search(3));
        newTree.delete(newTree.search(22));
        newTree.delete(newTree.search(7));
        newTree.delete(newTree.search(28));
        newTree.delete(newTree.search(19));
        System.out.println("After deleting 6 nodes the size of the tree is: " + newTree.getSize());
        System.out.println("Here is an in-order traversal of the tree after deleting nodes.");
        newTree.inOrder();
/**
 * Finally, invoke bstSort on at least 5 different arrays of different lengths
 with different values, and print the results to the console. The results of
 bstSort should always print in sorted order.
 */
        int[] arr2 = {13,4,5,6,11,6,12,10};
        System.out.println("\n\nHere is the initial array: \n" + arrayPrinter(arr2));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr2);

        int[] arr3 = {27,44,15,16,21,26,12,55,19,22,18,32,12,13,35};
        System.out.println("Here is the initial array: \n" + arrayPrinter(arr3));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr2);

        int[] arr4 = {100,55, 112, 99, 14, 150, 111, 44, 15, 77, 125, 32, 33};
        System.out.println("Here is the initial array: \n" + arrayPrinter(arr4));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr4);

        int[] arr5 = {50,40, 60, 70, 80, 22, 55, 75, 25};
        System.out.println("Here is the initial array: \n" + arrayPrinter(arr5));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr5);

        int[] arr6 = {44,14,15,16,51,66,60,10,11,33,40,50,45};
        System.out.println("Here is the initial array: \n" + arrayPrinter(arr6));
        System.out.print("Here is the array after bstSort: \n");
        bstSort(arr6);
    }//main


}
