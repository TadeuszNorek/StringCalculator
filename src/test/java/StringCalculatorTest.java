import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


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
    @Test
    public void moreNumbersTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void newlineDelimeterTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }
    @Test
    public void differentDelimeterTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }
    @Test
    public void negativesTest() {
        StringCalculator stringCalculator = new StringCalculator();

        try {
            stringCalculator.add("-2");
            fail("Failed, exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -2");
        }
    }
    @Test
    public void biggerThan1000Test() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, StringCalculator.add("//;\n1;2;1001"));
    }
    @Test
    public void anyLengthDelimeterTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void multipleDelimetersTest() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }
}
