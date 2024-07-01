package data;

import javax.xml.crypto.Data;

public class Node {
    private Data data;
    private Node next;
    private Object data;

    public Node() {
        this.data = null;
        next = null;
    }
    
    public Node(Data dato) {
        this.data = dato;
        next = null;
    }

    public Data getData() {
        return data;
    }

    public void setDato(Data data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return " " + data +"\n";
    }

    
    
    
    
    
}
