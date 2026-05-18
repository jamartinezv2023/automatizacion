package co.edu.udea.calidad.automatizacion.models;

public class Product {
    private final String name;
    private final int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String name() { return name; }
    public int quantity() { return quantity; }
}
