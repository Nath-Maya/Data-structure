package Activity_8;


// OBJETO QUE REPRESENTA UN CAMIÓN
public class Truck {

    //ATRIBUTOS
    private final int code;       
    private final String plate;   
    private final String driver;  

    //CONSTRUCTOR
    public Truck(int code, String plate, String driver) {
        this.code = code;
        this.plate = plate;
        this.driver = driver;
    }

    //METODOS GETTER
    public int getCode() {
        return code;
    }

    public String getPlate() {
        return plate;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %d | Placa: %s | Conductor: %s", code, plate, driver);
    }
}
