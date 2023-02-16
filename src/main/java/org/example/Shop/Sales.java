package org.example.Shop;

import org.example.entity.User;
import org.example.system.OrderSystem;
import org.example.system.ProductSystem;
import org.example.system.UserSystem;
import org.example.util.Application;
import org.example.util.Order;
import org.example.util.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Sales  implements Application {
    private final List<Order> orderList = new ArrayList<>();
    private final List<Product> productList = new ArrayList<>();
    private final List<User> userList = new ArrayList<>();
    private OrderSystem orderSystem = new OrderSystem();
    private ProductSystem productSystem = new ProductSystem();
    private UserSystem userSystem = new UserSystem();


    @Override
    public void start() {
        System.out.println("welcome to SHOP");
        System.out.println("[1] -> add user");
        System.out.println("[2] -> add product");
        System.out.println("[3] -> buy product");
        System.out.println("[4] -> illustrate all users");
        System.out.println("[5] -> illustrate all products");
        System.out.println("[6] -> illustrate all orders");
        System.out.println("[7] -> close app");
        Scanner in = new Scanner(System.in);
        boolean run = true;
        while (run){
            System.out.println("enter key number");
            int command = in.nextInt();
            switch (command){
                case 1 -> userSystem.addUser(getUserList());
                case 2 -> productSystem.addProduct(getProductList());
                case 3 -> orderSystem.registerOrder(getOrderList(),getUserList(),getProductList());
                case 4 -> this.getUserList().forEach(System.out::println);
                case 5 -> this.getProductList().forEach(System.out::println);
                case 6 -> this.getOrderList().forEach(System.out::println);
                case 7 -> exit();
                default -> System.out.println("incorrect number");
            }
        }
    }

    public List<User> getUserList() {
        userSystem.checkTypes(userList);
        Collections.sort(userList, Comparator.comparing(User::getId));
        return this.userList;//.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
