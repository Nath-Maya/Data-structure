package Activity_11;

 //NODO PARA EL ARBOL AVK
 //Contiene los siguientes atributos:
 //key: es el valor del nodo
 //height: indica la altura del nodo en el arbol
 //Left y Right: referencias a los nodos hijos izquierdo y derecho
 
public class Node {
    int key; // valor del nodo
    int height; // altura del nodo en el árbol
    Node left; // hijo izquierdo
    Node right; // hijo derecho

    // CONSTRUCTOR
    public Node(int key) {
        this.key = key;
        this.height = 1; // nuevo nodo inicialmente se considera hoja
        this.left = null;
        this.right = null;
    }

    // GETTERS Y SETTERS
    public int getKey() { return key; }
    public int getHeight() { return height; }
    public void setHeight(int h) { this.height = h; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }
    public void setLeft(Node l) { this.left = l; }
    public void setRight(Node r) { this.right = r; }
}
