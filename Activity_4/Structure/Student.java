package Activity_4.Structure;

public class Student {

    //ATRIBUTOS
    private int identificationCode;
    private String name;
    private String lastName;
    private int age;

    //ESTRUCTURAS ANIDADAS
    private Birthdate birthdate;
    private Address address;
    private Grades grades;

    //CONSTRUCTOR
    public Student(int identificationCode, String name, String lastName, int age, Birthdate birthdate, Address address, Grades grades) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
        this.address = address;
        this.grades = grades;
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

    //METODOS GETTER PARA LAS ESTRUCTURAS ANIDADAS
    public Birthdate getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public Grades getGrades() {
        return grades;
    }

}
