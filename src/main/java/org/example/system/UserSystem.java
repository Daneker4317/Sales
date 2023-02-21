package org.example.system;

import org.example.entity.LoyalUser;
import org.example.entity.OrdinaryUser;
import org.example.entity.PrimeUser;
import org.example.entity.User;
import org.example.util.Order;

import java.util.List;
import java.util.Scanner;

public class UserSystem {
    private Scanner in = new Scanner(System.in);



    public void addUser(List<User> userList){

        System.out.println("choose type of user");
        System.out.println("[1] ->  prime user");
        System.out.println("[2] ->  loyal user");
        System.out.println("[3] ->  ordinary user");
        int userType = in.nextInt();


        System.out.println("enter user name");
        String name = in.next();

        System.out.println("enter user surname");
        String surname  = in.next();

        System.out.println("enter user balance");
        double balance = in.nextDouble();

        userSwitcher( userList, userType , name , surname , balance);

        System.out.println("user added");

    }


    private void userSwitcher( List<User> userList, int userType , String name , String surname , Double balance){
        switch (userType){
            case 1 -> {
                userList.add(new PrimeUser(
                        name , surname , balance
                ));
            }
            case 2 -> {
                userList.add(new LoyalUser(
                        name , surname , balance
                ));
            }
            default -> {
                userList.add(new OrdinaryUser(
                        name , surname , balance
                ));
            }
        }
    }

    public void checkTypes(List<User> userList){
        for(User user : userList){
            if(user.getOrders().size() > 10 && user instanceof OrdinaryUser){
                convertToPrimeUser(user ,userList);
            } else if (user.getOrders().size() > 10 && user instanceof LoyalUser) {
                ((LoyalUser) user).setCashback(user.getOrders().size() % 10);
            }else if (user.getOrders().stream().map(Order::getPrice).mapToDouble(Double::doubleValue).sum() > 1000 && user instanceof PrimeUser){
                convertToLoyal(user , userList ) ;
            }
        }
        
    }
    
    private void convertToPrimeUser(User ordinaryUser , List<User> userList){
        PrimeUser primeUser = new PrimeUser(
                ordinaryUser.getName(),
                ordinaryUser.getSurname(),
                ordinaryUser.getBalance()
        );
        userList.remove(ordinaryUser);
        primeUser.setId(ordinaryUser.getId());
        primeUser.setOrders(ordinaryUser.getOrders());
        userList.add(primeUser);
    }
    
    private void convertToLoyal(User primeUser , List<User> userList ){
        LoyalUser loyalUser = new LoyalUser(
                primeUser.getName(),
                primeUser.getSurname(),
                primeUser.getBalance()
        );
        userList.remove(primeUser);
        loyalUser.setId(primeUser.getId());
        loyalUser.setOrders(primeUser.getOrders());
        userList.add(loyalUser);
    }

}
