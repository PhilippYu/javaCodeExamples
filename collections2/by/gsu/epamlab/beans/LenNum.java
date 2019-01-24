package by.gsu.epamlab.beans;

import java.util.Objects;

public class LenNum implements Comparable<LenNum>{
    private int len;
    private int num;

    public LenNum() {
    }

    public LenNum(int len) {
        this.len = len;
        num = 1;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getNum() {
        return num;
    }

    public void iterateNum() {
        this.num++;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof LenNum){
            return ((LenNum) o).len == len;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(len);
    }

    @Override
    public int compareTo(LenNum lenNum) {
        return this.len - lenNum.len;
    }

    @Override
    public String toString() {
        return len + ";" +
                num;
    }
}
