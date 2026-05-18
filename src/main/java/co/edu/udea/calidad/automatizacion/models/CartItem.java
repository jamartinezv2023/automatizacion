package co.edu.udea.calidad.automatizacion.models;

public final class CartItem {
    private final String name;
    private final int quantity;
    private final double price;

    public CartItem(String name, int quantity, double price){
        this.name = name; this.quantity = quantity; this.price = price;
    }

    public String name(){ return name; }
    public int quantity(){ return quantity; }
    public double price(){ return price; }
}

