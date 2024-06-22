package DoubleLinkedList;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private long length;

    public DoubleLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public DoubleLinkedList(String... values){
        this.head = null;
        this.tail = null;
        this.length = 0;

        for(String value : values){
            addLast(value);
            length++;
        }
    }

    public DoubleLinkedList(boolean toPrepend, String... values){
        this.head = null;
        this.tail = null;
        this.length = 0;

        if(toPrepend){
            for(String value : values){
                prepend(value);
                length++;
            }
        } else {
            for(String value : values){
                addLast(value);
                length++;
            }
        }

    }

    public void prepend(String value){
        if(head == null){
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        length++;
    }

    public void addLast(String value){
        if(tail == null){
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        length++;
    }

    public void removeFirst(){
        if(head == null)
            return;

        head = head.getNext();

        // This script sets the prev value of head to null
        if(head != null)
            head.setPrev(null);
        else
            tail = null;

        length--;
    }

    public void pop(){
        if (tail == null)
            return;

        tail = tail.getPrev();

        // This script sets the next value of tail to null
        if(tail != null)
            tail.setNext(null);
        else
            head = null;

        length--;
    }

    public void print(){
        System.out.print("Elements of the list: ");
        if(head != null){
            Node current = head;
            while(current != null){
                System.out.print(current.getValue() + " ");
                current = current.getNext();
            }
        }
    }

    public long getLength(){
        return length;
    }

    public Node getTail(){
        return tail;
    }

    public Node getHead(){
        return head;
    }
}
