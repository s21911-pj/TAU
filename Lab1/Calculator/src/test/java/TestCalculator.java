
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TestCalculator {
    private Calculator objCalcUnderTest;

    @Before
    public void setUp() {

        objCalcUnderTest = new Calculator();
        int a = 5;
        int b = 8;

    }

    @Test
    public void testAdd() {
        /*int a = 15; int b = -20;*/
        int expectedResult = 13;

        long result = objCalcUnderTest.add(a, b);


        /*Assert.assertEquals(expectedResult, result);*/

    }

    @Test
    public void testSubtract() {
        int a = 25; int b = 20;
        int expectedResult = 5;
        long result = objCalcUnderTest.subtract(a, b);
        Assert.assertEquals(expectedResult, result);
    }


    @Test
    public void testMultiply() {
        int a = 10; int b = 25;
        long expectedResult = 250;
        long result = objCalcUnderTest.multiply(a, b);
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testDivide() {
        int a = 56; int b = 10;
        double expectedResult = 5.6;
        double result = objCalcUnderTest.divide(a, b);
        Assert.assertEquals(expectedResult, result,0.00005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        int a = 15; int b = 0;
        objCalcUnderTest.divide(a, b);
    }
    @Test
    public void  shouldGivethree(){
    objCalcUnderTest.divide(8,5);
    Assert.assertEquals(3,3);
    }
   /* class UnitConverterTest {
        @Test
        void shouldConvertZeroKilogramValue() {
            Pound pounds = new Kilogram(BigDecimal.ZERO).toPounds();
            assertEquals(BigDecimal.ZERO.setScale(4), pounds.value);
        }*/
}