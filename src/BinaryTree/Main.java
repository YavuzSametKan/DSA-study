package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(7);
        tree.insert(10);
        tree.insert(9);
        tree.insert(4);

        System.out.print("pre-oreder: ");
        tree.traversePreOrder();
        System.out.print("\nin-order  : ");
        tree.traverseInOrder();
        System.out.print("\npost-order: ");
        tree.traversePostOrder();
    }
}
