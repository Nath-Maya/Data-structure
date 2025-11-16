package Activity_9;

public class Professor {

    // ATRIBUTOS
    private int code; // código del profesor
    private String firstName; // nombre
    private String lastName; // apellido
    private String phone; // celular

    // CONSTRUCTOR
    public Professor(int code, String firstName, String lastName, String phone) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    // GETTERS

    // Metodo para obtener el código
    public int getCode() {
        return code;
    }

    // Metodo para obtener el nombre
    public String getFirstName() {
        return firstName;
    }

    // Metodo para obtener el apellido
    public String getLastName() {
        return lastName;
    }

    // Metodo para obtener el celular
    public String getPhone() {
        return phone;
    }

    // Representación en texto
    @Override
    public String toString() {
        return "Codigo: " + code + ", Nombre: " + firstName + " " + lastName + ", Telefono/Celular: " + phone;
    }
}
