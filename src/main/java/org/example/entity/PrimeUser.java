package org.example.entity;

public class PrimeUser extends User {

    public PrimeUser(String name, String surname, double balance ) {
        super(name, surname, balance);
    }

    @Override
    public double calculateCurrentBalance(double price) {
       this.setBalance(this.getBalance() - price);
       return this.getBalance();
    }

}
