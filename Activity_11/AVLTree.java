package Activity_11;

import java.util.ArrayList;
import java.util.List;

//  IMPLEMENTACION DEL ARBOL AVL

//La deteccion del desequilibrio se enfatiza en el facto de equilibrio, es decir, la diferencia de alturas entre subarbol derecho e izquierdo.
//Si el valor absoluto del factor de equilibrio es mayor que 1, se considera que el nodo está desbalanceado y se aplica la rotación correspondiente.

// Si hay una insercion o eliminacion que ocasione el desembale en un nodo, se verifica si el hijo correspondiente está desequilibrado en sentido opuesto para determinar si se requiere una rotación doble (LR o RL).

public class AVLTree {

    private Node root; // raiz del arbol
    private boolean currentOperationIsDeletion = false; // indica si la operacion actual es una eliminacion

    // DATOS PARA REPORTAR LA PRIMERA ROTACION DOBLE DURANTE ELIMINACIONES
    private boolean firstDoubleRotationRecorded = false;
    private String firstDoubleRotationType = null; // "LR" o "RL"
    private int firstDoubleRotationTriggeredByKey = Integer.MIN_VALUE;
    private String beforeDoubleRotationSnapshot = null;
    private String afterDoubleRotationSnapshot = null;

    // CONSTRUCTOR
    public AVLTree() {
        this.root = null;
    }

    // METODOS PUBLICOS PARA INSERTAR Y ELIMINAR
    public void insert(int key) {
        this.currentOperationIsDeletion = false;
        System.out.println(AnsiColors.CYAN + "Insertando: " + key + AnsiColors.RESET);
        root = insertRec(root, key);
    }

    public void delete(int key) {
        this.currentOperationIsDeletion = true;
        System.out.println(AnsiColors.CYAN + "Eliminando: " + key + AnsiColors.RESET);
        root = deleteRec(root, key);
    }

    // METODO PARA OBTENER EL REPORTE DE LA PRIMERA ROTACION DOBLE DURANTE ELIMINACIONES
    public String getFirstDoubleRotationReport() {
        //Verifica si se ha registrado una rotación doble durante las eliminaciones
        if (!firstDoubleRotationRecorded) return "No se encontro ninguna rotacion la momento de eliminar.";
        StringBuilder sb = new StringBuilder();
        sb.append("1era rotacion doble detectada durante la eliminacion de: ").append(firstDoubleRotationTriggeredByKey).append('\n');
        sb.append("Tipo: ").append(firstDoubleRotationType).append('\n');
        sb.append("Arbol antes de la rotacion:\n").append(beforeDoubleRotationSnapshot).append('\n');
        sb.append("Árbol después de la rotación:\n").append(afterDoubleRotationSnapshot).append('\n');
        return sb.toString();
    }

    // OPERACIONES INTERNAS DE INSERCION Y ELIMINACION
    private Node insertRec(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        } else {
            return node;
        }

        // Actualizar altura
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        // Detectar desbalance
        if (Math.abs(balance) > 1) {
            System.out.println(AnsiColors.YELLOW + "⚠️ Desbalance se detecta en nodo " + node.key + " (FE=" + balance + ")" + AnsiColors.RESET);
        }

        // Casos de rotación
        // Left Left
        if (balance < -1 && key < node.left.key) {
            // Rotación simple derecha
            System.out.println(AnsiColors.GREEN + "🔁 Rotación simple (Right Rotate) en nodo " + node.key + AnsiColors.RESET);
            return rightRotate(node);
        }

        // Right Right
        if (balance > 1 && key > node.right.key) {
            // Rotación simple izquierda
            System.out.println(AnsiColors.GREEN + "🔁 Rotación simple (Left Rotate) en nodo " + node.key + AnsiColors.RESET);
            return leftRotate(node);
        }

        // Left Right
        if (balance < -1 && key > node.left.key) {
            System.out.println(AnsiColors.RED + "🔄 Rotación doble (Left-Right) en nodo " + node.key + AnsiColors.RESET);
            return leftRightRotate(node);
        }

        // Right Left
        if (balance > 1 && key < node.right.key) {
            System.out.println(AnsiColors.RED + "🔄 Rotación doble (Right-Left) en nodo " + node.key + AnsiColors.RESET);
            return rightLeftRotate(node);
        }

        return node;
    }

    private Node deleteRec(Node node, int key) {
        if (node == null) {
            System.out.println(AnsiColors.CYAN + "Clave no encontrada: " + key + AnsiColors.RESET);
            return null;
        }

        if (key < node.key) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRec(node.right, key);
        } else {
            // nodo encontrado
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {
                    // sin hijos
                    node = null;
                } else {
                    node = temp; // one child
                }
            } else {
                // dos hijos: obtener sucesor inorder
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = deleteRec(node.right, temp.key);
            }
        }

        if (node == null) return null;

        // actualizar altura
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);

        if (Math.abs(balance) > 1) {
            System.out.println(AnsiColors.YELLOW + "⚠️ Desbalance encontrado en nodo " + node.key + " (FE=" + balance + ")" + AnsiColors.RESET);
        }

        // Rotaciones correctoras después de eliminación
        // Caso Left Left
        if (balance < -1 && getBalance(node.left) <= 0) {
            System.out.println(AnsiColors.GREEN + "🔁 Rotación simple (Right Rotate) en nodo " + node.key + AnsiColors.RESET);
            return rightRotate(node);
        }

        // Left Right
        if (balance < -1 && getBalance(node.left) > 0) {
            System.out.println(AnsiColors.RED + "🔄 Rotación doble (Left-Right) en nodo " + node.key + AnsiColors.RESET);
            return leftRightRotate(node);
        }

        // Right Right
        if (balance > 1 && getBalance(node.right) >= 0) {
            System.out.println(AnsiColors.GREEN + "🔁 Rotación simple (Left Rotate) en nodo " + node.key + AnsiColors.RESET);
            return leftRotate(node);
        }

        // Right Left
        if (balance > 1 && getBalance(node.right) < 0) {
            System.out.println(AnsiColors.RED + "🔄 Rotación doble (Right-Left) en nodo " + node.key + AnsiColors.RESET);
            return rightLeftRotate(node);
        }

        return node;
    }

    // Devuelve el nodo con el valor mínimo en el subárbol
    public Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Altura segura
    public int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // FE = altura(right) - altura(left)
    public int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.right) - getHeight(node.left);
    }

    // ROTACIONES
    public Node rightRotate(Node y) {
        // y es raíz del subárbol desbalanceado
        String before = printTreeToString();

        Node x = y.left;
        Node T2 = x.right;

        // rotación
        x.right = y;
        y.left = T2;

        // actualizar alturas
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        String after = printTreeToString();

        // Si fue una rotación doble antes registrada durante eliminación, guardamos snapshot
        recordDoubleRotationIfNeeded("RL", before, after);

        return x; // nueva raíz del subárbol
    }

   // ROTACION IZQUIERDA
    public Node leftRotate(Node x) {
        String before = printTreeToString();

        Node y = x.right;
        Node T2 = y.left;

        // rotación
        y.left = x;
        x.right = T2;

        // actualizar alturas
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        String after = printTreeToString();
        recordDoubleRotationIfNeeded("LR", before, after);

        return y;
    }

    //ROTACION DOBLE IZQUIERDA-DERECHA

    public Node leftRightRotate(Node z) {
        // Snapshot antes
        String before = printTreeToString();

        // Primero rotación izquierda en hijo izquierdo
        z.left = leftRotate(z.left);
        // Luego rotación derecha en z
        Node res = rightRotate(z);

        String after = printTreeToString();
        // Registrar tipo LR si es la primera rotación doble durante una eliminación
        recordFirstDoubleRotationIfDeletion("LR", before, after);

        return res;
    }

    //ROTACION DOBLE DERECHA-IZQUIERDA

    public Node rightLeftRotate(Node z) {
        String before = printTreeToString();

        z.right = rightRotate(z.right);
        Node res = leftRotate(z);

        String after = printTreeToString();
        recordFirstDoubleRotationIfDeletion("RL", before, after);

        return res;
    }

// METODOS DE REGISTRO DE ROTACIONES DOBLES DURANTE ELIMINACIONES
    private void recordFirstDoubleRotationIfDeletion(String type, String before, String after) {
        if (this.currentOperationIsDeletion && !firstDoubleRotationRecorded) {
            firstDoubleRotationRecorded = true;
            firstDoubleRotationType = type;
            firstDoubleRotationTriggeredByKey = lastDeletedKey;
            beforeDoubleRotationSnapshot = before;
            afterDoubleRotationSnapshot = after;
        }
    }

    
    private void recordDoubleRotationIfNeeded(String guessedType, String before, String after) {

    }

    // -------------------- Impresión del árbol --------------------
    public void printTree() {
        System.out.println(printTreeToString());
    }

    // IMPRESION EN FORMATO STRING DEL ARBOL
    public String printTreeToString() {
        StringBuilder sb = new StringBuilder();
        buildString(root, "", true, sb);
        return sb.toString();
    }

    private void buildString(Node node, String prefix, boolean isTail, StringBuilder sb) {
        if (node == null) {
            sb.append(prefix).append(isTail ? "└── " : "├── ").append("null\n");
            return;
        }
        sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.key).append(" (h=").append(node.height).append(")\n");
        List<Node> children = new ArrayList<>();
        if (node.left != null) children.add(node.left);
        if (node.right != null) children.add(node.right);

        if (children.size() == 0) return;

        for (int i = 0; i < children.size() - 1; i++) {
            buildString(children.get(i), prefix + (isTail ? "    " : "│   "), false, sb);
        }
        buildString(children.get(children.size() - 1), prefix + (isTail ? "    " : "│   "), true, sb);
    }

    // ESTADO ACTUAL DEL ARBOL
    private int lastDeletedKey = Integer.MIN_VALUE;

    // Método de conveniencia para la eliminación que registra la clave actual (usado por el Main)
    public void deleteWithRecord(int key) {
        this.lastDeletedKey = key;
        delete(key);
    }
}
