package by.gsu.epamlab.reader;

import by.gsu.epamlab.beans.Comp;
import by.gsu.epamlab.beans.LenNum;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TxtReader {
    private final String PACKAGE;
    private final String FILE_NAME;
    private final String EXTENSION = ".txt";

    private List<LenNum> lenNums = new ArrayList<>();

    public TxtReader(String PACKAGE, String FILE_NAME) {
        this.PACKAGE = PACKAGE;
        this.FILE_NAME = FILE_NAME;
    }

    public void read() throws FileNotFoundException {
        final String REGEX = "[)(]";
        final String SEMICOLON = ";";
        Scanner scanner = null;
        try {
            FileReader fileReader = new FileReader(PACKAGE + FILE_NAME + EXTENSION);
            scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()){
                double x1, x2, y1, y2;
                String test = scanner.nextLine().replaceAll("\\s", "");
                String[] coordinates = test.split(REGEX);
                x1 = Double.parseDouble(coordinates[1].split(SEMICOLON)[0]);
                y1 = Double.parseDouble(coordinates[1].split(SEMICOLON)[1]);
                x2 = Double.parseDouble(coordinates[3].split(SEMICOLON)[0]);
                y2 = Double.parseDouble(coordinates[3].split(SEMICOLON)[1]);
                int length = (int) Math.round(Math.sqrt((x2 - x1)*(x2-x1) + (y2 - y1)*(y2 - y1)));
                LenNum newLenNum = new LenNum(length);
                int i = Collections.binarySearch(lenNums, newLenNum);
                if (i < 0){
                    lenNums.add(newLenNum);
                } else {
                    lenNums.get(i).iterateNum();
                }
            }
        } finally {
            if (scanner != null){
                scanner.close();
            }
        }
    }

    public List<LenNum> getLenNums() {
        return lenNums;
    }
}
