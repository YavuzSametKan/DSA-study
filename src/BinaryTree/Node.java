package BinaryTree;

public class Node {
    //////////////////////////////// Attributes //////////////////////////////////

    private int data;
    private Node left;
    private Node right;
    private long piece;

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Constructors ////////////////////////////////

    public Node(int data){
        this.data = data;
        this.piece = 1;
        this.left = null;
        this.right = null;
    }

    //////////////////////////////////////////////////////////////////////////////

    //////////////////////////////// Getters Setters /////////////////////////////

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void incrementPiece(){
        this.piece++;
    }

    public void decrementPiece(){
        this.piece--;
    }

    public void resetPiece(){
        this.piece = 0;
    }

    //////////////////////////////////////////////////////////////////////////////
}
