package by.gsu.epamlab.beans;

import java.util.Comparator;

public class Comp implements Comparator<LenNum> {
    @Override
    public int compare(LenNum lenNum, LenNum t1) {
        return t1.getNum() - lenNum.getNum();
    }
}
