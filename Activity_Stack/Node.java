package Activity_Stack;


// Nodo para la pila que contiene un Artículo y una referencia al siguiente nodo.
public class Node {

    //ATRIBUTOS
    private Article data;
    private Node next;

    //CONSTRUCTOR
    public Node(Article data) {
        this.data = data;
        this.next = null;
    }

    // GETTERS Y SETTERS
    public Article getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
