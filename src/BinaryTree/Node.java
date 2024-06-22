package BinaryTree;

public class Node {
    //////////////////////////////// Attributes //////////////////////////////////

    private int data;
    private Node left;
    private Node right;
    private long piece;
    private long height;

    //////////////////////////////// Constructors ////////////////////////////////

    public Node(int data){
        this.data = data;
        this.piece = 1;
        this.height = 0;
        this.left = null;
        this.right = null;
    }

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

    public long getPiece() {
        return this.piece;
    }

    public void incrementPiece(){
        this.piece++;
    }

    public void decrementPiece(){
        if (this.piece > 0) {
            this.piece--;
        }
    }

    public void resetPiece(){
        this.piece = 0;
    }

    public long getHeight() {
        return this.height;
    }

    public void setHeight(long height) {
        this.height = height;
    }
}
