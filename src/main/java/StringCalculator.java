public class StringCalculator {

    public static int add(String numbers) {
        int sum = 0;
        if (numbers.equals(""))
            return 0;
        String[] list = getNumbersList(numbers);
        if (list.length>0)
            for (int i = 0; i<2; i++) {
                sum+= Integer.parseInt(list[i]);
            }

        return sum;
    }

    private static String[] getNumbersList(String numbers) {
        String listOfNumbers = numbers;
        return listOfNumbers.split(",");
    }
}
