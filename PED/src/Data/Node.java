package Data;



public class Node {
    private Tiquete data;
    private Node next;
    //Cambios data
    //private Object data;
    //Prueba

    public Node() {
        this.data = null;
        next = null;
    }
    
    public Node(Tiquete dato) {
        this.data = dato;
        next = null;
    }

    public Tiquete getData() {
        return data;
    }

    public void setDato(Tiquete data) {
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
