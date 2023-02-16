package org.example.util;

public class Product {
    private static int PRODUCT_COUNT;
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product( String name, int quantity, double price) {
        this.id = ++PRODUCT_COUNT;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean changeQuantity(int value){
        if(this.quantity < value){
            return false;
        }
        this.quantity -= value;
        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
