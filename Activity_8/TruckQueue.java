package Activity_8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;


public class TruckQueue {

    // Cola FIFO para camiones
    // Estructura principal
    private final Queue<Truck> queue;
    private final Set<Integer> codes; 
    private final Set<String> plates;

    // Constructor
    public TruckQueue() {
    
        this.queue = new LinkedList<>();
        this.codes = new HashSet<>();
        this.plates = new HashSet<>();
    }

   //METODO PARA AGREGAR CAMION A LA COLA
    public void enqueue(Truck truck) {
        // Validaciones para evitar duplicados
        if (codes.contains(truck.getCode())) {
            throw new IllegalArgumentException("Este codigo ya existe: " + truck.getCode());
        }
        if (plates.contains(truck.getPlate())) {
            throw new IllegalArgumentException("Esta placa ya existe: " + truck.getPlate());
        }

        // Agregar a la cola y a los sets auxiliares
        queue.add(truck);
        codes.add(truck.getCode());
        plates.add(truck.getPlate());
    }

    //Metodo para verificar si la cola está vacía
    public boolean isEmpty() {
        return queue.isEmpty();
    }


    //Metodo para mostrar los camiones en la cola
    public void display() {
        if (queue.isEmpty()) {
            System.out.println("[vacío]");
            return;
        }
        // Recorremos la cola una sola vez (un bucle esencial)
        for (Truck t : queue) {
            System.out.println(t);
        }
    }
}
