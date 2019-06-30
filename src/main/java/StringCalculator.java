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
        return listOfNumbers.split(",|\n");
    }
}
