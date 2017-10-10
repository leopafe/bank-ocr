import java.util.Arrays;

public class Parser {

    public String[] line1Reader(String input) {
        if (input == "   ") {
            return new String[]{"1", "4"};
        } else if (input == " _ ") {
            return new String[]{"2", "3", "5", "6", "7", "8", "9"};
        } else {
            return new String[]{"?"};
        }
    }

    public String[] line2Reader(String input) {
        if (input == " _|") {
            return new String[]{"2", "3"};
        } else if (input == "  |") {
            return new String[]{"1", "7"};

        } else if(input == "|_ "){

            return new String[]{"5", "6"};
        } else if(input == "|_|") {
            return new String[]{"4", "8", "9"};
        }

        return new String[]{"?"};
    }

    public String[] line3Reader(String input) {
        if (input == "  |") {
            return new String[]{"1", "4", "7"};
        } else if (input == "|_ ") {
            return new String[]{"2"};

        } else if(input == " _|"){

            return new String[]{"3", "5", "9"};
        } else if(input == "|_|") {
            return new String[]{"6", "8"};
        }

        return new String[]{"?"};
    }

    public String parseDigit(String[] input) {
        String[] result1 = null;
        String[] result2 = null;
        String[] result3 = null;
        for(int i = 0; i < input.length; i++){
            if(i == 0) {
                result1 = line1Reader(input[i]);
            } else if (i == 1) {
                result2 = line2Reader(input[i]);
            } else if (i == 2) {
                result3 = line3Reader(input[i]);
            }
        }
        return arrayIntersection(result1, result2, result3)[0];
    }

    public String[] arrayIntersection(String[] a, String[] b, String[] c) {
        return Arrays.stream(Arrays.stream(a)
                .filter(x -> Arrays.stream(b)
                        .anyMatch(y -> y.equals(x))
                ).toArray(String[]::new))
                .filter(y -> Arrays.stream(c)
                        .anyMatch(z -> z.equals(y))
                ).toArray(String[]::new);
    }
}
