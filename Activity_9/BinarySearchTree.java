package Activity_9;

import java.util.ArrayList;
import java.util.List;

/**
 * Árbol binario de búsqueda simple para almacenar objetos Profesor
 * El criterio de ordenamiento es el código del profesor (entero).
 */
public class BinarySearchTree {

    private class Node {
        Profesor data;
        Node left, right;

        Node(Profesor data) {
            this.data = data;
        }
    }

    private Node root;

    // Insertar un profesor en el árbol. Devuelve false si ya existe el código.
    public boolean insert(Profesor p) {
        if (root == null) {
            root = new Node(p);
            return true;
        }
        Node current = root;
        while (true) {
            if (p.getCode() == current.data.getCode()) {
                return false; // duplicado
            } else if (p.getCode() < current.data.getCode()) {
                if (current.left == null) {
                    current.left = new Node(p);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(p);
                    return true;
                }
                current = current.right;
            }
        }
    }

    // Buscar por código
    public Profesor find(int code) {
        Node current = root;
        while (current != null) {
            if (code == current.data.getCode()) return current.data;
            if (code < current.data.getCode()) current = current.left;
            else current = current.right;
        }
        return null;
    }

    // Eliminar nodo por código. Devuelve true si se eliminó.
    public boolean delete(int code) {
        DeletionResult res = deleteRec(root, code);
        if (res.deleted) root = res.node;
        return res.deleted;
    }

    // Helper para eliminación que devuelve nodo nuevo y flag
    private DeletionResult deleteRec(Node node, int code) {
        if (node == null) return new DeletionResult(null, false);
        if (code < node.data.getCode()) {
            DeletionResult res = deleteRec(node.left, code);
            node.left = res.node;
            return new DeletionResult(node, res.deleted);
        } else if (code > node.data.getCode()) {
            DeletionResult res = deleteRec(node.right, code);
            node.right = res.node;
            return new DeletionResult(node, res.deleted);
        } else {
            // encontrado: tres casos
            if (node.left == null && node.right == null) {
                return new DeletionResult(null, true);
            } else if (node.left == null) {
                return new DeletionResult(node.right, true);
            } else if (node.right == null) {
                return new DeletionResult(node.left, true);
            } else {
                // dos hijos: reemplazar por sucesor mínimo del subárbol derecho
                Node successor = findMin(node.right);
                node.data = successor.data;
                DeletionResult res = deleteRec(node.right, successor.data.getCode());
                node.right = res.node;
                return new DeletionResult(node, true);
            }
        }
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    private static class DeletionResult {
        Node node;
        boolean deleted;

        DeletionResult(Node node, boolean deleted) {
            this.node = node;
            this.deleted = deleted;
        }
    }

    // Recorrido inorder para obtener lista ordenada por código
    public List<Profesor> inOrder() {
        List<Profesor> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node node, List<Profesor> out) {
        if (node == null) return;
        inOrderRec(node.left, out);
        out.add(node.data);
        inOrderRec(node.right, out);
    }

    // Reconstruir árbol desde una lista (útil después de cargar desde archivo)
    public void buildFromList(List<Profesor> list) {
        root = null;
        if (list == null) return;
        for (Profesor p : list) insert(p);
    }
}
