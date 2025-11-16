package Activity_9;

// Nodo de la lista enlazada que almacena un profesor
public class Node {
    private Professor data; // datos del profesor
    private Node next; // referencia al siguiente nodo

    // CONSTRUCTOR
    public Node(Professor data) {
        this.data = data;
        this.next = null;
    }

    // GETTERS Y SETTERS

    // Metodo para capturar los datos del profesor
    public Professor getData() {
        return data;
    }

    // Metodo para tomar el siguiente nodo
    public Node getNext() {
        return next;
    }

    // Metodo para determinar el siguiente nodo
    public void setNext(Node next) {
        this.next = next;
    }
}
