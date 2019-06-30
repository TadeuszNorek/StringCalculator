public class StringCalculator {

    public static int add(String numbers) {
        int sum = 0;
        if (numbers.equals(""))
            return 0;
        String[] list = getNumbersList(numbers);
        for (String s: list) {
            sum+= Integer.parseInt(s);
        }
        return sum;
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
