package Activity_Stack;

// Esta es la implementacion dela pila (stack) usando una lista enlazada simple.
public class Stack {

    private Node top; // referencia al elemento en la cima de la pila

    // CONSTRUCTOR
    public Stack() {
        this.top = null;
    }

    //Metodo para agregar un artículo a la pila, con el metodo push (LIFO)
    public void push(Article article) {
        Node node = new Node(article);
        // Apunta el nuevo nodo al anterior tope
        node.setNext(top);
        top = node;
    }

    // Metodo para eliminar y devolver el artículo en la cima de la pila
    public Article pop() {
        if (isEmpty()) return null;
        Article data = top.getData();
        top = top.getNext();
        return data;
    }

    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Muestra los elementos en orden LIFO sin modificar la pila
    public void display() {
        if (isEmpty()) {
            System.out.println("No hay artículos para mostrar.");
            return;
        }
        // Recorre desde el tope hacia abajo
        Node current = top;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // (No hay métodos adicionales para evitar iteraciones innecesarias)
}
