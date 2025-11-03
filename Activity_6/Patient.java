package Activity_6;

/**
 * Clase que representa el registro (estructura) de un paciente.
 * Contiene los campos básicos y métodos de acceso.
 */
public class Patient {

    private int code; // código del paciente
    private String name; // nombre
    private String lastName; // apellido
    private String address; // dirección
    private String phone; // teléfono
    private int age; // edad

    public Patient(int code, String name, String lastName, String address, String phone, int age) {
        this.code = code;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    // Getters y setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Code: %d | %s %s | Age: %d | Phone: %s | Addr: %s", code, name, lastName, age, phone, address);
    }
}
