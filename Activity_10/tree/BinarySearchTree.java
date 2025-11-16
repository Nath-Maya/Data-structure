package Activity_10.tree;

import Activity_10.model.Budget;
import Activity_10.model.Node;
import java.util.ArrayList;
import java.util.List;


//ARBOL BINARIO DE BUSQUEDA PARA OBJETOS BUDGET
// Su objetivo es almacenar presupuestos ordenados por su ID (entero).
// Permite insertar, buscar, eliminar y recorrer en orden.

public class BinarySearchTree {

    //ATRIBUTOS
    private Node root;
    private String lastDeletionCase = ""; // para informar el caso de eliminación

    //CONSTRUCTOR
    public BinarySearchTree() {
        this.root = null;
    }

    // Insertar presupuesto en el árbol (no permite IDs duplicados).
    public boolean insert(Budget b) {
        // caso base: si el árbol está vacío
        if (root == null) {
            root = new Node(b);
            return true;
        }
        return insertRec(root, b);
    }

    // Metodo que usa recursion para insertar el presupuesto
    private boolean insertRec(Node node, Budget b) {
        // caso base: duplicado
        if (b.getId() == node.data.getId()) return false; // duplicado
        // decidir ir a la izquierda o derecha
        if (b.getId() < node.data.getId()) {
            if (node.left == null) {
                node.left = new Node(b);
                return true;
            }
            return insertRec(node.left, b);
        } else {
            // ir a la derecha
            if (node.right == null) {
                node.right = new Node(b);
                return true;
            }
            return insertRec(node.right, b);
        }
    }

    // Metodo para buscar un presupuesto por ID
    public Budget search(int id) {
        // recorrido iterativo
        Node cur = root;
        // Ciclo while para buscar el ID
        while (cur != null) {
            if (id == cur.data.getId()) return cur.data;
            cur = (id < cur.data.getId()) ? cur.left : cur.right;
        }
        return null;
    }

    // Metodo para eliminar un presupuesto por ID
    public boolean delete(int id) {
        DeletionResult res = deleteRec(root, id);
        root = res.node;
        // Si resultado es true, actualizar el caso de eliminación
        if (res.deleted) this.lastDeletionCase = res.delCase;
        return res.deleted;
    }

    // Metodo para eliminar un nodo de forma recursiva
    private DeletionResult deleteRec(Node node, int id) {
        // caso base
        if (node == null) return new DeletionResult(null, false, "");
        if (id < node.data.getId()) {
            // ir a la izquierda
            DeletionResult res = deleteRec(node.left, id); // llamar recursivamente
            node.left = res.node; // actualizar hijo izquierdo
            return new DeletionResult(node, res.deleted, res.delCase); // retornar resultado
        } else if (id > node.data.getId()) {
            // ir a la derecha
            DeletionResult res = deleteRec(node.right, id);// llamada recursiva
            node.right = res.node; // actualizar hijo derecho
            return new DeletionResult(node, res.deleted, res.delCase); // retornar resultado
        } else {
            
            // Nodo encontrado: manejar los 3 casos de eliminación
            // nodo hoja
            if (node.left == null && node.right == null) {
                return new DeletionResult(null, true, "leaf");
            }
            // un solo hijo
            if (node.left == null) {
                return new DeletionResult(node.right, true, "one-child");
            } else if (node.right == null) {
                return new DeletionResult(node.left, true, "one-child");
            }
            // dos hijos: encontrar sucesor mínimo en subárbol derecho
            Node successor = findMin(node.right);
            node.data = successor.data; // copiar datos
            DeletionResult res = deleteRec(node.right, successor.data.getId());
            node.right = res.node;
            return new DeletionResult(node, true, "two-children");
        }
    }

    // Metodo auxiliar para encontrar el nodo con el valor mínimo
    private Node findMin(Node node) {
        Node cur = node;
        while (cur.left != null) cur = cur.left;
        return cur;
    }

    //CLASE AUXILIAR PARA RESULTADO DE ELIMINACION
    private static class DeletionResult {

        //ATRIBUTOS
        Node node;
        boolean deleted;
        String delCase;

        //CONSTRUCTOR
        DeletionResult(Node node, boolean deleted, String delCase) {
            this.node = node;
            this.deleted = deleted;
            this.delCase = delCase;
        }
    }

    // Crear una lista con los presupuestos en orden ascendente por ID
    public List<Budget> inorderTraversal() {
        List<Budget> out = new ArrayList<>();
        inorderRec(root, out);
        return out;
    }

    // Metodo recursivo para recorrido inorder
    private void inorderRec(Node node, List<Budget> out) {
        if (node == null) return;
        inorderRec(node.left, out);
        out.add(node.data);
        inorderRec(node.right, out);
    }

    // Obtener el caso de la última eliminación realizada
    public String getLastDeletionCase() {
        return lastDeletionCase;
    }
}
