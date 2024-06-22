package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList DLL = new DoubleLinkedList("1","2","3","4","5");

        // Deletion Transections
        DLL.removeFirst();
        DLL.pop();

        // Printing Result
        DLL.print();

        System.out.println();
        // Roaming
        System.out.println("tail -> prev -> prev: " + DLL.getTail().getPrev().getPrev().getValue());
        System.out.println("head -> next -> next: " + DLL.getHead().getNext().getNext().getValue());
    }
}