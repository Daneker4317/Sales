package org.example.system;

import org.example.util.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductSystem {


    private Scanner in = new Scanner(System.in);



    public void addProduct(List<Product> productList){
        System.out.println("enter name of product:");
        String name = in.next();

        System.out.println("enter quantity of product:");
        int quantity = in.nextInt();

        System.out.println("enter price of product: ");
        double price = in.nextDouble();

        productList.add(new Product(
                name , quantity , price
        ));

        System.out.println("product added");
    }


}
