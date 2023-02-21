package org.example.entity;

import org.example.util.Order;

import java.util.ArrayList;
import java.util.List;


public abstract class User {
    private int id;
    private static int USER_COUNT;
    private String name;
    private String surname;
    private double balance;
    private List<Order> orders;

    public User(String name, String surname, double balance) {
        this.id = ++USER_COUNT;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.orders = new ArrayList<>();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public abstract double calculateCurrentBalance(double price);



    @Override
    public String toString() {
        String info = "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                ", user type: " + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1) +
                '}';

        if (!orders.isEmpty()) {
            info += "orders: ";
            for(Order order : orders){
                info+=order.toString() + " ";
            }
        }

        return info;
    }

}
