package model;

public class Product {
    private String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {

        if (id.isEmpty()) throw  new IllegalArgumentException("Product's id can not be empty!");
        if (name.isEmpty()) throw new IllegalArgumentException("Product's name can not be empty!");
        if (price <= 0) throw new IllegalArgumentException("Product's price must > 0!");
        if (stock < 0) throw new IllegalArgumentException("Product's stock must >= 0 !");
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) throw new IllegalArgumentException("Product's price must > 0!");
        this.price = price;
    }

    void decreaseStock(int quantity) {
        if (quantity == 0) throw new IllegalArgumentException("Quantity must > 0");
        if (quantity > this.stock) throw new IllegalArgumentException("Quantity must < stock !");

        this.stock -= quantity;
    }

    public String getDescription() {
        return id + " | " + name + " | " + price;
    }
}
