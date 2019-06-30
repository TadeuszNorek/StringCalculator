import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StringCalculatorTest {
    @Test
    public void emptyStringTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void oneNumberTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    public void twoNumbersTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, StringCalculator.add("1,2"));
    }
}
