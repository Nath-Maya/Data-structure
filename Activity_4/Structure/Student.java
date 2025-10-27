package Activity_4.Structure;

public class Student {

    // ATRIBUTOS
    private int identificationCode;
    private String name;
    private String lastName;
    private int age;

    // ESTRUCTURAS ANIDADAS
    private Birthdate birthdate;
    private Address address;
    private Grades grades;

    // CONSTRUCTOR
    public Student(int identificationCode, String name, String lastName, int age, Birthdate birthdate, Address address,
            Grades grades) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birthdate = birthdate;
        this.address = address;
        this.grades = grades;
    }

    // METODOS GETTER
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

    // METODOS GETTER PARA LAS ESTRUCTURAS ANIDADAS
    public Birthdate getBirthdate() {
        return birthdate;
    }

    public Address getAddress() {
        return address;
    }

    public Grades getGrades() {
        return grades;
    }

    public double getAverageGrade() {
        return grades.calculateAverage();
    }

    // Método toString para representar al estudiante como una cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(identificationCode).append("\n");
        sb.append("Nombre: ").append(name).append(" ").append(lastName).append("\n");
        sb.append("Edad: ").append(age).append("\n");
        sb.append("Fecha de nacimiento: ").append(birthdate != null ? birthdate.toString() : "N/A").append("\n");
        sb.append("Dirección: ").append(address != null ? address.toString() : "N/A").append("\n");
        sb.append("Notas: \n");
        if (grades != null) {
            for (String key : grades.getGradesMap().keySet()) {
                sb.append("  ").append(key).append(": ").append(grades.getGradesMap().get(key)).append("\n");
            }
            sb.append("  Promedio: ").append(String.format("%.2f", grades.calculateAverage())).append("\n");
        } else {
            sb.append("  N/A\n");
        }
        return sb.toString();
    }

}
