public class StringCalculator {

    public static int add(String numbers) throws IllegalArgumentException {
        int sum = 0;
        if (numbers.equals(""))
            return 0;
        String[] list = getNumbersList(numbers);
        String negatives = "";
        for (String s: list) {
            if (Integer.parseInt(s)<0)
                negatives += " " + s;
            else if (Integer.parseInt(s)<=1000)
                sum+= Integer.parseInt(s);
        }
        if (negatives == "")
            return sum;
        else throw new IllegalArgumentException("negatives not allowed" + negatives);
    }

    private static String[] getNumbersList(String numbers) {
        String listOfNumbers = numbers;
        if (numbers.startsWith("//"))
            listOfNumbers = numbers.split("\n")[1];
        return listOfNumbers.split(getRegex(numbers));
    }

    private static String getRegex(String numbers) {
        String regex = ",|\n";
        if (numbers.startsWith("//")){
            regex = "\n|" + numbers.charAt(2);
        }
        return regex;
    }
}
