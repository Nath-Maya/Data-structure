package Activity_4.Structure;

public class Address {

    // ATRIBUTOS
    // Estructura de arreglo para direccion: direccion, estrato, barrio y ciudad

    private String[] addressArray = new String[4];

    // CONSTRUCTOR
    public Address(String address, String stratum, String neighborhood, String city) {
        this.addressArray[0] = address; // direccion se asigna en el index 0
        this.addressArray[1] = stratum; // estrato se asigna en el index 1
        this.addressArray[2] = neighborhood; // barrio se asigna en el index 2
        this.addressArray[3] = city; // ciudad se asigna en el index 3
    }

    // METODO GETTER
    public String[] getAddressArray() {
        return addressArray;
    }

    public String getAddress() {
        return addressArray[0];
    }

    public String getStratum() {
        return addressArray[1];
    }

    public String getNeighborhood() {
        return addressArray[2];
    }

    public String getCity() {
        return addressArray[3];
    }

    @Override
    public String toString() {
        return getAddress() + ", Estrato: " + getStratum() + ", Barrio: " + getNeighborhood() + ", Ciudad: "
                + getCity();
    }
}
