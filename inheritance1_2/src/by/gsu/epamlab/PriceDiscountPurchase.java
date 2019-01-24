package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discountPercent;

    public PriceDiscountPurchase() {
        super();
    }

    public PriceDiscountPurchase(String productName, Byn price, int numberOfPurchasedUnits, Byn discountPercent) {
        super(productName, price, numberOfPurchasedUnits);
        this.discountPercent = discountPercent;
    }

    public PriceDiscountPurchase(Scanner scanner){
        super(scanner.next(), new Byn(scanner.nextInt()), scanner.nextInt());
        this.discountPercent = new Byn(scanner.nextInt());
    }

    public Byn getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Byn discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public Byn getCost() {
        Byn cost = new Byn(discountPercent);
        return super.getCost().sub(cost.mul(getNumberOfPurchasedUnits()));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discountPercent;
    }
}
