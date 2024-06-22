package DoubleLinkedList;

public class Node {
    private String value;
    private Node prev;
    private Node next;

    public Node(String value){
        setValue(value);
        setNext(null);
        setPrev(null);
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node node){
        this.next = node;
    }

    public Node getPrev(){
        return prev;
    }

    public void setPrev(Node node){
        this.prev = node;
    }
}
