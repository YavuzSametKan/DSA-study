package BinaryTree;

public class Main {
    public static void main(String[] args) {

        //////////////////// Creating a Tree and Add Some Items //////////////////////

        BinaryTree tree = new BinaryTree(15, 6);
        tree.insert(18);
        tree.insert(3);
        tree.insert(7);
        tree.insert(18, 30, 2, 4, 13, 9, 14);
        tree.insert(14);

        /////////////////////////////// Printing the Tree ////////////////////////////

        tree.print();

        ////////////////////////////////// Traversing ////////////////////////////////

        System.out.print("\npre-oreder: ");
        tree.traversePreOrder();
        System.out.print("\nin-order  : ");
        tree.traverseInOrder();
        System.out.print("\npost-order: ");
        tree.traversePostOrder();

        ////////////////////////////////// Binary Search ////////////////////////////

        System.out.println("\n\nis there a 1 in the tree: " + tree.isThere(1));
        System.out.println("is there a 9 in the tree: " + tree.isThere(9));
        System.out.println("is there a 4 in the tree: " + tree.isThere(4));

        //////////////////////////// Getting Minimum - Maximum //////////////////////

        System.out.println("\nMinimum value: " + tree.getMinimum());
        System.out.println("Maximum value: " + tree.getMaximum());

    }
}
