package Activity_6;

/**
 * Nodo para la lista doblemente enlazada. Contiene un Patient y referencias
 * al siguiente y al anterior nodo.
 */
public class Node {
    private Patient data;
    private Node next;
    private Node previous;

    public Node(Patient data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Patient getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
