import by.gsu.epamlab.beans.Comp;
import by.gsu.epamlab.beans.LenNum;
import by.gsu.epamlab.reader.TxtReader;

import java.io.FileNotFoundException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        TxtReader txtReader = new TxtReader("src/", "in");
        try {
            txtReader.read();
            List<LenNum> lenNums = txtReader.getLenNums();
            lenNums.sort(new Comp());
            System.out.println(lenNums);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
