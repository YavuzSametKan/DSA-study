package BinaryTree;

public class BinaryTree {
    //////////////////////////////// Attributes //////////////////////////////////

    private Node root;

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Constructors ////////////////////////////////

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int value){
        root = new Node(value);
    }

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Traverse Methods ////////////////////////////

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node current){
        if(current == null) return;

        System.out.print(current.getData() + " ");
        traversePreOrder(current.getLeft());
        traversePreOrder(current.getRight());
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node current){
        if(current == null) return;

        traverseInOrder(current.getLeft());
        System.out.print(current.getData() + " ");
        traverseInOrder(current.getRight());
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node current){
        if(current == null) return;

        traversePostOrder(current.getLeft());
        traversePostOrder(current.getRight());
        System.out.print(current.getData() + " ");
    }

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Insertion Methods ///////////////////////////

    public void insert(int value){
        insert(root, value);
    }

    private Node insert(Node current, int value){
        if(current == null)
            return new Node(value);

        if(current.getData() > value){
            current.setLeft(
                    insert(current.getLeft(), value)
            );
        }
        else if (current.getData() < value){
            current.setRight(
                    insert(current.getRight(), value)
            );
        }
        else
            current.incrementPiece();

        return current;
    }

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Printing Methods ////////////////////////////

    public void print() {
        print(root, "root", 0);
    }

    private void print(Node current, String position, int depth) {
        if (current != null) {
            System.out.println("\t".repeat(depth) + position + ": " + current.getData());

            if(current.getLeft() != null)
                print(current.getLeft(), "left", depth + 1);

            if(current.getRight() != null)
                print(current.getRight(), "right", depth + 1);
        }
    }

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Getters Setters /////////////////////////////

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //////////////////////////////////////////////////////////////////////////////
}
