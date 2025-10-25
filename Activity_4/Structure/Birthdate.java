package Activity_4.Structure;
public class Birthdate {

    //ATRIBUTOS
    //Estructura arreglo para fecha de nacimiento : dia, mes, año
    //Me permite limitar los datos a almacenar, en este caso 3 datos

    private int [] birthdateArray = new int[3];

    //CONSTRUCTOR
    public Birthdate(int birthday, int birthMonth , int birthAge) {
        this.birthdateArray[0] = birthday;
        this.birthdateArray[1] = birthMonth ;
        this.birthdateArray[2] = birthAge;
    }

    //METODO GETTER 
    public int[] getBirthdateArray() {
        return birthdateArray;
    }
    
}
