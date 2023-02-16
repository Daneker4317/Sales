package org.example.entity;


public class LoyalUser extends User{

    private double cashback;

    public LoyalUser(String name, String surname, double balance) {
        super(name, surname, balance);
        this.cashback = 0.94;
    }

    public double getCashback() {
        return cashback;
    }

    @Override
    public double calculateCurrentBalance(double price) {
       this.setBalance(this.getBalance() - price);
       return this.getBalance();
    }

    public void setCashback(int n) {
        if(this.cashback - n * 0.01 < 0.9){
            return;
        }
        this.cashback -= n * 0.01;
    }

}
