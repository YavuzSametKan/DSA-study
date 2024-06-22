package BinaryTree;

public class BinaryTree {
    //////////////////////////////// Attributes //////////////////////////////////

    private Node root;

    //////////////////////////////// Constructors ////////////////////////////////

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(int value){
        root = new Node(value);
    }

    public BinaryTree(int... values){
        for(int value : values){
            insert(value);
        }
    }

    //////////////////////////////// AVL Tree Methods ////////////////////////////

    private Node rotateLeft(Node pivot){
        Node rightOfPivot = pivot.getRight();
        Node leftOfRightOfPivot = rightOfPivot.getLeft();

        // Rotation Operations
        pivot.setRight(leftOfRightOfPivot);
        rightOfPivot.setLeft(pivot);

        // Update Heights
        updateHeight(pivot);
        updateHeight(rightOfPivot);

        // Return new root node
        return rightOfPivot;
    }

    private Node rotateRight(Node pivot){
        Node leftOfPivot = pivot.getLeft();
        Node rightOfLeftOfPivot = leftOfPivot.getRight();

        // Rotation Operations
        leftOfPivot.setRight(pivot);
        pivot.setLeft(rightOfLeftOfPivot);

        // Update Heights
        updateHeight(pivot);
        updateHeight(leftOfPivot);

        // Return new root node
        return leftOfPivot;
    }

    private Node rotateLeftRight(Node pivot) {
        pivot.setLeft(rotateLeft(pivot.getLeft()));
        return rotateRight(pivot);
    }

    private Node rotateRightLeft(Node pivot) {
        pivot.setRight(rotateRight(pivot.getRight()));
        return rotateLeft(pivot);
    }

    private byte getBalanceFactor(Node node){
        if (node == null) return 0;
        return (byte)(getHeight(node.getLeft()) - getHeight(node.getRight()));
    }

    private long getHeight(Node node){
        if (node == null) return -1;
        return node.getHeight();
    }

    private void updateHeight(Node node){
        node.setHeight(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
    }

    //////////////////////////////// AVL Insertion //////////////////////////////

    public void insert(int... values){
        for(int value : values){
            insert(value);
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node current, int value){
        if(current == null)
            return new Node(value);

        if(value < current.getData()){
            current.setLeft(insert(current.getLeft(), value));
        }
        else if(value > current.getData()){
            current.setRight(insert(current.getRight(), value));
        }
        else {
            current.incrementPiece();
            return current;
        }

        // Update height of this ancestor node
        updateHeight(current);

        // Check balance factor to maintain AVL property
        int balanceFactor = getBalanceFactor(current);

        // Left Left Case
        if(balanceFactor > 1 && value < current.getLeft().getData())
            return rotateRight(current);

        // Right Right Case
        if(balanceFactor < -1 && value > current.getRight().getData())
            return rotateLeft(current);

        // Left Right Case
        if(balanceFactor > 1 && value > current.getLeft().getData()) {
            current.setLeft(rotateLeft(current.getLeft()));
            return rotateRight(current);
        }

        // Right Left Case
        if(balanceFactor < -1 && value < current.getRight().getData()) {
            current.setRight(rotateRight(current.getRight()));
            return rotateLeft(current);
        }

        // Return the (unchanged) node pointer
        return current;
    }

    //////////////////////////////// Printing Methods ////////////////////////////

    public void print() {
        print(root, "root", 0);
    }

    private void print(Node current, String position, int depth) {
        if (current != null) {
            System.out.println("⎯→".repeat(depth) + position + ": " + current.getData());

            if(current.getLeft() != null)
                print(current.getLeft(), "left", depth + 1);

            if(current.getRight() != null)
                print(current.getRight(), "right", depth + 1);
        }
    }

    //////////////////////////////// Getters Setters /////////////////////////////

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //////////////////////////////// Traversal Methods //////////////////////////

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

    //////////////////////////////// Searching Methods ///////////////////////////

    public boolean isThere(int data){
        return isThere(root, data);
    }

    private boolean isThere(Node current, int data){
        if (current == null) return false;

        if (current.getData() > data){
            return isThere(current.getLeft(), data);
        } else if (current.getData() < data){
            return isThere(current.getRight() , data);
        } else {
            return true;
        }
    }

    public Integer getMinimum(){
        if (root == null) return null;

        Node current = root;

        while(current.getLeft() != null){
            current = current.getLeft();
        }

        return current.getData();
    }

    public Integer getMaximum(){
        if (root == null) return null;

        Node current = root;

        while(current.getRight() != null){
            current = current.getRight();
        }

        return current.getData();
    }
}