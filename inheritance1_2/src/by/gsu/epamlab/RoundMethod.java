package by.gsu.epamlab;

public enum RoundMethod {
    FLOOR{
        double roundFunction(double number){
            return Math.floor(number);
        }
    },
    ROUND{
        double roundFunction(double number) {
            return Math.round(number);
        }

        double roundfFunction(double number){
            return Math.round(number);
        }
    },
    CEIL{
        double roundFunction(double number){
            return Math.ceil(number);
        }
    };

    abstract double roundFunction(double number);
    int round(double roundedValue, int a){
        int tenPow = pow10(a);
        int result = (int) roundFunction(roundedValue/tenPow) * tenPow;
        return result;
    }

    static int pow10 (int a){
        if(a == 0)
            return 1;
        int result = 10;
        for(int i = 1;i < a;i++){
            result *=10;
        }
        return result;
    }
}
