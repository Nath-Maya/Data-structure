package Activity_4.Structure;
public class Birthdate {

    //ATRIBUTOS
    private int birthday;
    private int birthMonth;
    private int birthAge;

    //CONSTRUCTOR
    public Birthdate(int birthday, int birthMonth , int birthAge) {
        this.birthday = birthday;
        this.birthMonth = birthMonth  ;
        this.birthAge = birthAge;
    }

    //METODOS GETTER
    public int getbirthday() {
        return birthday;
    }

    public int getbirthMonth  () {
        return birthMonth ;
    }

    public int getbirthAge() {
        return birthAge;
    }
    
}
