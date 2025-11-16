package Activity_9;

import java.io.Serializable;


public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code; // codigo que identifica al profesor y se usa para ordenarlo
    private String name; // nombre
    private String lastName; // apellido
    private String phone; // celular

    public Profesor(int code, String name, String lastName, String phone) {
        this.code = code;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("Codigo: %d | %s %s | Cel: %s", code, name, lastName, phone);
    }
}
