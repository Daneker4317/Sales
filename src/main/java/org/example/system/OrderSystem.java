package org.example.system;

import org.example.entity.LoyalUser;
import org.example.entity.PrimeUser;
import org.example.entity.User;
import org.example.util.Order;
import org.example.util.Product;


import java.util.List;
import java.util.Scanner;

public class OrderSystem {
    private Scanner in = new Scanner(System.in);


    public void registerOrder(List<Order> orderList , List<User> userList , List<Product> productList){

        if(productList.isEmpty() || userList.isEmpty()){
            System.out.println("user list or product list is empty");
        }

        userList.forEach(System.out::println);
        System.out.println("enter user id who wanna buy product:");
        int userIndex =  in.nextInt() - 1;
        if(userIndex >= userList.size()){
            System.out.println("invalid user id :(");
            return;
        }

        productList.forEach(System.out::println);
        System.out.println("enter product id:");
        int productIndex = in.nextInt() - 1;
        if(productIndex >= productList.size()){
            System.out.println("invalid product id :(");
            return;
        }

        System.out.println("enter quantity of product for buy:");
        int quantity = in.nextInt();
        if(quantity > productList.get(productIndex).getQuantity()){
            System.out.println("not enough product in stock");
            return;
        }

        if(quantity * productList.get(productIndex).getPrice() >
                userList.get(userIndex).getBalance()){
            System.out.println("u brat not enough money");
            return;
        }


        productList.get(productIndex).setQuantity(productList.get(productIndex).getQuantity() - quantity);
        userList.get(userIndex).calculateCurrentBalance(quantity * productList.get(productIndex).getPrice() * bonus(userList.get(userIndex)));

        Order order = new Order(
                userIndex+1, productList.get(productIndex).getName() ,
                quantity , quantity * productList.get(productIndex).getPrice() * bonus(userList.get(userIndex))
        );

        orderList.add(order);
        userList.get(userIndex).addOrder(order);

        System.out.println("Thank you for your purchase [" +
                "balance after payment: " + userList.get(userIndex).getBalance() + "$ ] | [total sum:  " +  order.getPrice()+ "$] ");
    }

    private double bonus(User user){
        return  user instanceof PrimeUser ? 0.95 : user instanceof LoyalUser ? ((LoyalUser) user).getCashback() : 1;
    }
}
