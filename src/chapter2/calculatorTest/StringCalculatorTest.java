package chapter2.calculatorTest;

import chapter2.calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    private StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }

    @Test
    public void isEmptyOrNull() {
        assertEquals(0, cal.add(""));
        assertEquals(0, cal.add(null));
    }

    @Test
    public void split() {
        assertArrayEquals(new String[]{"1"}, "1".split(","));
        assertArrayEquals(new String[]{"1", "2"}, "1,2".split(","));
        assertEquals(6, cal.add("1,2:3"));
    }

    @Test
    public void custom_구분자() throws Exception{
        assertEquals(6, cal.add("//;\n1:2:3"));
    }

    @Test(expected = RuntimeException.class)
    public void add_negative() throws Exception{
        cal.add("-1,2,3");
    }
}
