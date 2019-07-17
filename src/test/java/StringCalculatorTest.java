import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class StringCalculatorTest {

    @Before
    public void init() {
        StringCalculator stringCalculator = new StringCalculator();
    }

    @Test
    public void emptyStringTest() {
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void oneNumberTest() {
        assertEquals(1, StringCalculator.add("1"));
    }
    @Test
    public void twoNumbersTest() {
        assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void moreNumbersTest() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
    @Test
    public void newlineDelimeterTest() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }
    @Test
    public void differentDelimeterTest() {
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
        assertEquals(3, StringCalculator.add("//;\n1;2;1001"));
    }
    @Test
    public void anyLengthDelimeterTest() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }
    @Test
    public void multipleDelimetersTest() {
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }
    @Test
    public void multipleAnyLengthDelimetersTest() {
        assertEquals(6, StringCalculator.add("//[****][%%]\n1****2%%3"));
    }
}
