import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) throws IllegalArgumentException {
        int sum = 0;
        if (numbers.equals(""))
            return 0;
        String[] list = getNumbersList(numbers, getRegex(numbers));
        StringBuilder negatives = new StringBuilder("");
        for (String s: list) {
            if (Integer.parseInt(s)<0)
                negatives.append(" ").append(s);
            else if (Integer.parseInt(s) <= 1000)
                sum+= Integer.parseInt(s);
        }
        if (negatives.toString().equals(""))
            return sum;
        else throw new IllegalArgumentException("negatives not allowed" + negatives);
    }

    private static String[] getNumbersList(String numbers, String regex) {
        String listOfNumbers = numbers;
        if (numbers.startsWith("//"))
            listOfNumbers = numbers.split("\n")[1];
        return listOfNumbers.split(regex);
    }

    private static String getRegex(String numbers) {
        String regex = ",|\n";
        if (numbers.startsWith("//[")){
            String[] delimeters = numbers.split("\\[");
            regex = "\n";
            StringBuilder sB = new StringBuilder(regex);
            for (int i=1; i<delimeters.length; i++){
                sB.append("|").append(Pattern.quote(delimeters[i].split("]")[0]));
            }
            regex = sB.toString();
        }
        else if (numbers.startsWith("//")){
            regex = "\n|" + numbers.charAt(2);
        }
        return regex;
    }
}
