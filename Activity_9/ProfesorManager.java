package Activity_9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ProfesorManager {

    //ATRIBUTOS
    private List<Profesor> list; // lista de manejo general (orden de inserción)
    private BinarySearchTree bst; // arbol binario par las operacciones por codigo
    private final String storageFile; // ruta del archivo de persistencia

    //CONSTRUCTOR
    public ProfesorManager(String storageFile) {
        this.list = new ArrayList<>();
        this.bst = new BinarySearchTree();
        this.storageFile = storageFile;
    }

    //METODOS PRINCIPALES
    // Registrar un profesor con validaciones
    public void registerProfesor(Scanner scanner) {
        System.out.println("\n--- Registrar profesor ---");

        int code = readInt(scanner, "Ingresar codigo (entero positivo): ");
        if (code <= 0) {
            System.out.println("Codigo no valido. La operacion fue cancelada.");
            return;
        }
        // Validar que no este duplicado en el arbol
        if (bst.find(code) != null) {
            System.out.println("Ya existe un profesor con ese código.");
            return;
        }

        // Capturar los datos
        String name = readNonEmpty(scanner, "Nombre: ");
        String lastName = readNonEmpty(scanner, "Apellido: ");
        System.out.print("Celular (opcional): ");
        String phone = scanner.nextLine().trim();
        Profesor p = new Profesor(code, name, lastName, phone);
        list.add(p);
        bst.insert(p);
        System.out.println("Profesor agregado ✅");
    }

    // Mostrar la lista completa en orden de inserción
    public void showAll() {
        System.out.println("\n--- LISTADO DE PROFESORES (orden de inserción) ---");
        if (list.isEmpty()) {
            System.out.println("(vacío)");
            return;
        }
        for (Profesor p : list) {
            System.out.println(p);
        }
    }

    // Guardar la lista completa en un archivo (serialización)
    public void saveToFile() {
        try (FileOutputStream fos = new FileOutputStream(storageFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
            System.out.println("✅ Datos guardados en archivo: " + storageFile);
        } catch (Exception e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    // Recuperar la lista desde archivo y reconstruir el árbol
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try (FileInputStream fis = new FileInputStream(storageFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                list = (List<Profesor>) obj;
                // Reconstruir árbol
                bst = new BinarySearchTree();
                bst.buildFromList(list);
                System.out.println("✅ Datos recuperados desde: " + storageFile);
                return;
            }
            System.out.println("El archivo no contiene una lista válida.");
        } catch (Exception e) {
            System.out.println("Error al recuperar datos: " + e.getMessage());
        }
    }

    // Buscar profesor por código usando el arbol binario
    // Se usa Scanner para leer la entrada del usuario
    // Metodo retorna void y muestra el resultado en consola
    public void searchByCode(Scanner scanner) {
        int code = readInt(scanner, "Ingrese codigo a buscar: ");
        Profesor p = bst.find(code);
        if (p == null) System.out.println("No encontrado.");
        else System.out.println("Encontrado: " + p);
    }

    // Eliminar profesor usando el codigo 
    public void deleteByCode(Scanner scanner) {
        int code = readInt(scanner, "Ingrese el código que quiere eliminar: ");
        // Primero eliminar en el arbol, esto garantiza que el código exista
        boolean removedFromTree = bst.delete(code);
        // Si no se encontró en el árbol, no existe
        if (!removedFromTree) {
            System.out.println("Código no fue encontrado en el árbol.");
            return;
        }
        // Eliminar de la lista (mantener orden de inserción)
        Iterator<Profesor> it = list.iterator();
        while (it.hasNext()) {
            Profesor p = it.next();
            if (p.getCode() == code) {
                it.remove();
                break;
            }
        }
        System.out.println("Profesor eliminado ✅");
    }

    // Lectura de entero con validacion para codigo
    private int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        
        String line = scanner.nextLine().trim();
        try {
        return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Entrada incorrecta. Se esperaba un número entero.");
            return -1;
        }
    }

    // Leer cadena que no este vacia
    private String readNonEmpty(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String s = scanner.nextLine().trim();
        if (s.isEmpty()) {
            System.out.println("No puede quedar vacío.");
            return readNonEmpty(scanner, prompt);
        }
        return s;
    }
}
