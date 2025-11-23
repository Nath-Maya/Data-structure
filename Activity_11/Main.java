package Activity_11;


public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Secuencia de inserciones y eliminaciones
        int[] sequence = {100, 29, 71, 82, 48, 39, 101, 22, 46, 17, 3, 20, 25, 10};

        // Realizar inserciones y eliminaciones, mostrando el árbol tras cada operación
        System.out.println("--- Inserciones ---");
        for (int k : sequence) {
            tree.insert(k);
            System.out.println("Estado del ARBOL lugo de insertar " + k + ":");
            tree.printTree();
            System.out.println();
        }

        System.out.println("--- Eliminaciones ---");
        for (int k : sequence) {
            // usamos deleteWithRecord para que el árbol pueda saber qué eliminación lo gatilló (registro)
            tree.deleteWithRecord(k);
            System.out.println("Estado del ARBOL luego de eliminar " + k + ":");
            tree.printTree();
            System.out.println();
        }

        System.out.println("--- Resumen final sobre rotaciones dobles ---");
        System.out.println(tree.getFirstDoubleRotationReport());
    }
}
