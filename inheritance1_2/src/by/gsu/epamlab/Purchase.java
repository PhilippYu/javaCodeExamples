package by.gsu.epamlab;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String productName;
    private Byn price;
    private int numberOfPurchasedUnits;

    public Purchase(){
        this(null,null,0);
    }

    public Purchase(String productName, Byn price, int numberOfPurchasedUnits) {
        this.productName = productName;
        this.price = new Byn(price);
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public Purchase(Scanner scanner){
        this(scanner.next(), new Byn(scanner.nextInt()),scanner.nextInt());
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public Byn getCost() {
        Byn cost = new Byn(price);
        return cost.mul(numberOfPurchasedUnits);
    }

    protected String fieldsToString() {
        return  productName + ";" + price + ";" + numberOfPurchasedUnits;
    }
    @Override
    public String toString() {
        return fieldsToString() + ";" + getCost();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase other = (Purchase) obj;
        if (productName == null) {
            if (other.productName != null) {
                return false;
            }
        } else if (!productName.equals(other.productName)) {
            return false;
        }
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        return true;
    }
}
