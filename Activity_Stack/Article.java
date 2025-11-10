package Activity_Stack;


public class Article {

    //ATRIBUTOS
    private int code;       
    private String name;    
    private String detail;  
    private double price;   

    //CONSTRUCTOR
    public Article(int code, String name, String detail, double price) {
        this.code = code;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

    // GETTERS Y SETTERS
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | %s | %s | Precio: %.2f", code, name, detail, price);
    }
}
