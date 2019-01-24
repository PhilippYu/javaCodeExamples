package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private double discount;
    protected final static int QUANTITY= 20;

    public PercentDiscountPurchase() {
        super();
    }

    public PercentDiscountPurchase(String name, Byn price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.discount = sc.nextDouble();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public Byn getCost() {
        double x = 1 - discount / 100;
        Byn cost =  super.getCost();
        if (getNumberOfPurchasedUnits() >= QUANTITY) {
            cost.mul(x, RoundMethod.ROUND, 0);
        }
        return cost;
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

}
