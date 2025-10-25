package Activity_4.Structure;

public class Student {

    //ATRIBUTOS
    private int identificationCode;
    private String name;
    private String lastName;
    private int age;

    //CONSTRUCTOR
    public Student(int identificationCode, String name, String lastName, int age) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.lastName = lastName;
        this.age = age;

    }

    //METODOS GETTER
    public int getIdentificationCode() {
        return identificationCode;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

}
