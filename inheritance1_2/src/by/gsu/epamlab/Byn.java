package by.gsu.epamlab;

public class Byn implements Comparable<Byn>	{
    private int numCoins;

    public Byn(){}
    public Byn(int numCoins) {
        this.numCoins = numCoins;
    }
    public Byn(int rubs, int coins) {
        this(rubs*100 + coins);
    }
    public Byn(Byn byn) {
        this(byn.numCoins);
    }
    public int getRubs() {
        return numCoins / 100;
    }
    public int getCoins() {
        return numCoins % 100;
    }
    public Byn add(Byn byn) {
        numCoins += byn.numCoins;
        return this;
    }
    public Byn sub(Byn byn) {
        numCoins -= byn.numCoins;
        return this;
    }
    public Byn mul(int k) {
        numCoins *= k;
        return this;
    }

    @Override
    public String toString() {
        return getRubs() + "." + getCoins() / 10 + getCoins() % 10;
    }

    public int compareTo(Byn byn){
        return this.numCoins - byn.numCoins;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Byn)) {
            return false;
        }
        Byn other = (Byn) obj;
        if (numCoins != other.numCoins) {
            return false;
        }
        return true;
    }

    public Byn mul(double k, RoundMethod roundMethod, int d){
        numCoins = roundMethod.round(numCoins * k, d);
        return this;
    }
    public Byn round(RoundMethod roundMethod, int d){
        numCoins = roundMethod.round(numCoins, d);
        return this;
    }
}
