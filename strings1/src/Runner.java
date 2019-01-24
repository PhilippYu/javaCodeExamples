import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static boolean isNumericInteger(String str)
    {
        try
        {
            int i = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        int errors = 0;
        int i = 0;
        double sum = 0;
        double firstSymbol[] = new double[100];
        String c;
        try {
            scanner = new Scanner(new FileReader("src/in.csv"));
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                String[] strings = s.split(";");
                c = strings[0];
                if (isNumericInteger(c)){
                    int x = Integer.parseInt(c);
                    if(x < strings.length) {
                        firstSymbol[i] = Double.parseDouble(strings[x]);
                        sum += firstSymbol[i];
                        i++;
                    } else {
                        errors++;
                    }
                }else {
                    errors++;
                }
            }

            System.out.println("result(" + firstSymbol[0]+ "+" + firstSymbol[1]+ "+" + firstSymbol[2] + ")" + "= " + sum);
            System.out.println("Error-lines = " + errors);

        } catch (FileNotFoundException e) {
            System.out.println("File is not found");
        }
    }
}