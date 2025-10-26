package Activity_4.Structure;

public class Birthdate {

    // ATRIBUTOS
    // Estructura arreglo para fecha de nacimiento : dia, mes, año
    // Me permite limitar los datos a almacenar, en este caso 3 datos

    private int[] birthdateArray = new int[3];

    // CONSTRUCTOR
    public Birthdate(int birthday, int birthMonth, int birthYear) {
        this.birthdateArray[0] = birthday; // dia se asigna en el index 0
        this.birthdateArray[1] = birthMonth; // mes se asigna en el index 1
        this.birthdateArray[2] = birthYear; // año se asigna en el index 2
    }

    // METODO GETTER
    public int[] getBirthdateArray() {
        return birthdateArray;
    }

    public int getDay() {
        return birthdateArray[0];
    }

    public int getMonth() {
        return birthdateArray[1];
    }

    public int getYear() {
        return birthdateArray[2];
    }

    // METODO TO STRING PARA IMPRIMIR FECHA DE NACIMIENTO
    @Override
    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }   

}
