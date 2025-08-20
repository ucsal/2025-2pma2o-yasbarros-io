package br.com.mariojp.solid.ocp;

public class DiscountCalculator {
    public double apply(double amount, CustomerType type){
        switch (type){
            case REGULAR: return amount * 0.95;
            case PREMIUM: return amount * 0.90;
            default: return amount;
        }
    }
}
