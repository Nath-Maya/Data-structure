package Activity_10.manager;

import Activity_10.model.Budget;
import Activity_10.tree.BinarySearchTree;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


//CLASE QUE GESTIONA LOS PRESUPUESTOS 
// Brinda metodos para registrar, mostrar, buscar, eliminar, guardar y cargar presupuestos.

public class BudgetManager {

    //ATRIBUTOS
    private BinarySearchTree bst;
    private List<Budget> list; // Lista para persistencia
    private final File storageFile;

    // Colores ANSI
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    //CONSTRUCTOR
    public BudgetManager(String storagePath) {
        this.bst = new BinarySearchTree();
        this.list = new ArrayList<>();
        File folder = new File("Activity_10/data");
        if (!folder.exists()) folder.mkdirs();
        this.storageFile = new File(storagePath);
    }

    //METODOS PRINCIPALES

    // Metodo para registrar un nuevo presupuesto
    public void registerBudget(Scanner scanner) {
        System.out.println(BLUE + "\n--- Ingresar presupuesto 💾 ---" + RESET);
        int id = readInt(scanner, "ID: ");
        if (id <= 0) { System.out.println(RED + "ID Incorrecto." + RESET); return; }
        if (bst.search(id) != null) { System.out.println(YELLOW + "⚠️ ID ya existe. No se insertó." + RESET); return; }
        System.out.print("Nombre cliente: ");
        String client = scanner.nextLine().trim();
        if (client.isEmpty()) { System.out.println(RED + "Nombre no puede quedar en blanco." + RESET); return; }
        System.out.print("Producto: ");
        String product = scanner.nextLine().trim();
        if (product.isEmpty()) { System.out.println(RED + "Producto no puede qquedar en blanco." + RESET); return; }
        int quantity = readInt(scanner, "Cantidad: ");
        if (quantity <= 0) { System.out.println(RED + "Cantidad incorrecta." + RESET); return; }
        double unitPrice = readDouble(scanner, "Precio unitario: ");
        if (unitPrice < 0) { System.out.println(RED + "Precio incorrecto." + RESET); return; }

        // Crear e insertar el presupuesto
        Budget b = new Budget(id, client, product, quantity, unitPrice);
        boolean inserted = bst.insert(b); // insertar en el ABB
        if (inserted) {
            list.add(b);
            System.out.println(GREEN + "✅ Presupuesto ingresado." + RESET);
        } else {
            System.out.println(YELLOW + "⚠️ No se pudo ingresar, el ID esta duplicado." + RESET);
        }
    }

    // Mostrar todos (in-order)
    public void showAll() {
        System.out.println(BLUE + "\n--- Listado de presupuestos (orden por ID) 🌳 ---" + RESET);
        List<Budget> ordered = bst.inorderTraversal();
        if (ordered.isEmpty()) { System.out.println(YELLOW + "(en blanco)" + RESET); return; }
        printTableHeader();
        for (Budget b : ordered) printBudgetRow(b);
    }

    // Guardar lista en archivo 
    //serialización
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(storageFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
            System.out.println(GREEN + "💾 Datos guardados en: " + storageFile.getPath() + RESET);
        } catch (Exception e) {
            System.out.println(RED + "Error al guardar: " + e.getMessage() + RESET);
        }
    }

    // Recuperar datos desde archivo y reconstruir el árbol
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        // Verificar si el archivo existe
        if (!storageFile.exists()) { System.out.println(YELLOW + "Archivo no existe: " + storageFile.getPath() + RESET); return; }
        try (FileInputStream fis = new FileInputStream(storageFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                this.list = (List<Budget>) obj;
                this.bst = new BinarySearchTree();
                for (Budget b : list) bst.insert(b);
                System.out.println(GREEN + "📂 Datos recuperados y árbol reconstruido." + RESET);
                return;
            }
            System.out.println(RED + "Archivo no contiene lista en blanco." + RESET);
        } catch (Exception e) {
            System.out.println(RED + "Error al recuperar: " + e.getMessage() + RESET);
        }
    }

    // Buscar presupuesto por ID
    public void searchById(Scanner scanner) {
        int id = readInt(scanner, "Ingrese ID a buscar: ");
        Budget b = bst.search(id);
        if (b == null) System.out.println(YELLOW + "🔍 No encontrado." + RESET);
        else { System.out.println(GREEN + "🔍 Encontrado:" + RESET); printTableHeader(); printBudgetRow(b); }
    }

    // Eliminar presupuesto por ID
    public void deleteById(Scanner scanner) {
        int id = readInt(scanner, "Ingrese ID a eliminar: ");
        boolean removed = bst.delete(id);
        if (!removed) { System.out.println(YELLOW + "⚠️ ID no encontrado en el árbol." + RESET); return; }
        // eliminar de la lista
        list.removeIf(b -> b.getId() == id);
        String delCase = bst.getLastDeletionCase();
        switch (delCase) {
            case "leaf":
                System.out.println(GREEN + "🗑️ Eliminado: nodo hoja." + RESET);
                break;
            case "one-child":
                System.out.println(GREEN + "🗑️ Eliminado: nodo con un hijo." + RESET);
                break;
            case "two-children":
                System.out.println(GREEN + "🗑️ Eliminado: nodo con dos hijos (reemplazado por sucesor)." + RESET);
                break;
            default:
                System.out.println(GREEN + "🗑️ Eliminado." + RESET);
        }
    }

    // Utilidades de entrada
    private int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try { return Integer.parseInt(line); } catch (NumberFormatException e) { return -1; }
    }

    private double readDouble(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        try { return Double.parseDouble(line); } catch (NumberFormatException e) { return -1; }
    }

    // Formato de tabla simple
    private void printTableHeader() {
        System.out.println("ID | Cliente | Producto | Cant | PrecioU | Total");
        System.out.println("----------------------------------------------------");
    }

    private void printBudgetRow(Budget b) {
        System.out.printf("%d | %s | %s | %d | %.2f | %.2f\n", b.getId(), b.getClientName(), b.getProduct(), b.getQuantity(), b.getUnitPrice(), b.getTotalPrice());
    }
}
