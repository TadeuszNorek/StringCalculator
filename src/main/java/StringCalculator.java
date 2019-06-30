public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.equals(""))
            return 0;
        int sum = 0;
        String[] list = getNumbersList(numbers);
        for (String s: list) {
            sum+= Integer.parseInt(s);
        }

        return sum;
    }

    private static String[] getNumbersList(String numbers) {
        String listOfNumbers = numbers;
        return listOfNumbers.split(",");
    }
}
