package Activity_9;

// Lista enlazada simple para almacenar profesores
public class ProfessorList {

    private Node head; // referencia al primer nodo

    public ProfessorList() {
        // Inicializa la lista vacía
        this.head = null;
    }

    // Agrega un profesor al final de la lista
    public void add(Professor professor) {
        // Crea un nuevo nodo
        Node newNode = new Node(professor);
        if (head == null) {
            head = newNode;
            return;
        }
        // Recorrer hasta el final de la lista
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    // Imprimir la lista completa
    public void printAll() {
        if (head == null) {
            System.out.println("No hay profesores registrados");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    // Busca y devuelve el profesor por codigo. Devuelve null si no lo encuentra.
    public Professor findByCode(int code) {
        Node current = head;
        while (current != null) {
            if (current.getData().getCode() == code) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    // Elimina el primer nodo cuyo profesor tenga el codigo indicado. Devuelve true si se eliminó.
    public boolean deleteByCode(int code) {
        if (head == null) return false;
        // Caso cabeza
        if (head.getData().getCode() == code) {
            head = head.getNext();
            return true;
        }
        // Caso intermedio o final
        Node prev = head; // Nodo anterior
        Node current = head.getNext(); // Nodo actual

        // Recorrer la lista
        while (current != null) {
            // Buscar el codigo
            if (current.getData().getCode() == code) {
                prev.setNext(current.getNext()); // Eliminar nodo
                return true;
            }
            // Avanzar nodos
            prev = current;
            current = current.getNext();
        }
        return false;
    }

    // Metodo para verificar si la lista se encuentra vacia
    public boolean isEmpty() {
        return head == null;
    }
}
