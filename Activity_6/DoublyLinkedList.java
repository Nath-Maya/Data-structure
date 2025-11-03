package Activity_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementación de una lista doblemente enlazada para manejar pacientes.
 * Esta clase se encarga únicamente de las operaciones sobre la estructura.
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Agrega un paciente al final de la lista
    public void addLast(Patient patient) {
        Node node = new Node(patient);
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.setNext(node);
        node.setPrevious(tail);
        tail = node;
    }

    // Busca un paciente por código; devuelve null si no existe
    public Patient findByCode(int code) {
        Node current = head;
        while (current != null) {
            if (current.getData().getCode() == code) return current.getData();
            current = current.getNext();
        }
        return null;
    }

    // Elimina el paciente por código; devuelve true si eliminó
    public boolean deleteByCode(int code) {
        Node current = head;
        while (current != null) {
            if (current.getData().getCode() == code) {
                Node prev = current.getPrevious();
                Node next = current.getNext();
                if (prev != null) prev.setNext(next); else head = next;
                if (next != null) next.setPrevious(prev); else tail = prev;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Actualiza los datos de un paciente encontrado por código; devuelve true si actualizó
    public boolean updateByCode(int code, Patient newData) {
        Node current = head;
        while (current != null) {
            if (current.getData().getCode() == code) {
                // actualizar campos (excepto el código que debe permanecer)
                current.getData().setName(newData.getName());
                current.getData().setLastName(newData.getLastName());
                current.getData().setAddress(newData.getAddress());
                current.getData().setPhone(newData.getPhone());
                current.getData().setAge(newData.getAge());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Devuelve una lista de pacientes cuya edad coincida con la solicitada
    public List<Patient> findByAge(int age) {
        List<Patient> result = new ArrayList<>();
        Node current = head;
        while (current != null) {
            if (current.getData().getAge() == age) result.add(current.getData());
            current = current.getNext();
        }
        return result;
    }

    // Devuelve todos los pacientes en una lista ordenada ascendentemente por código
    public List<Patient> toListAscByCode() {
        List<Patient> list = toList();
        Collections.sort(list, Comparator.comparingInt(Patient::getCode));
        return list;
    }

    // Devuelve todos los pacientes en una lista ordenada descendentemente por código
    public List<Patient> toListDescByCode() {
        List<Patient> list = toList();
        Collections.sort(list, Comparator.comparingInt(Patient::getCode).reversed());
        return list;
    }

    // Convierte la lista doble en una lista Java para facilitar visualización/ordenamiento
    private List<Patient> toList() {
        List<Patient> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
