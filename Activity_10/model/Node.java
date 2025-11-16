package Activity_10.model;

// CLASE QUE REPRESENTA UN NODO DEL ARBOL BINARIO DE BUSQUEDA (ABB)
// Contiene un Budget y referencias a los nodos izquierdo y derecho.
public class Node {

    //ATRIBUTOS
    public Budget data;
    public Node left;
    public Node right;

    //CONSTRUCTOR
    public Node(Budget data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
