package Activity_10.model;

import java.io.Serializable;

// CLASE QUE REPRESENTA UN PRESUPUESTO
// Contiene id, nombre cliente, producto, cantidad, precio unitario y precio total.

public class Budget implements Serializable {

    private static final long serialVersionUID = 1L;

    //ATRIBUTOS
    private int id;
    private String clientName;
    private String product;
    private int quantity;
    private double unitPrice;
    private double totalPrice;

    //CONSTRUCTOR
    public Budget(int id, String clientName, String product, int quantity, double unitPrice) {
        this.id = id;
        this.clientName = clientName;
        this.product = product;
        setQuantity(quantity);
        setUnitPrice(unitPrice);
    }


    //METODOS GETTER Y SETTER
    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    // El setter de cantidad
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        recalcTotal();
    }

    // El setter de precio unitario
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        recalcTotal();
    }

    // Recalcula el precio total
    private void recalcTotal() {
        this.totalPrice = this.quantity * this.unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s | %d | %.2f | %.2f", id, clientName, product, quantity, unitPrice, totalPrice);
    }
}
