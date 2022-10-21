
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class TestCalculator {
    private Calculator objCalcUnderTest;

    @Before
    public void setUp() {

        objCalcUnderTest = new Calculator();

    }

    @Test
    public void testAdd() {
        int a = 15; int b = -20;
        int expectedResult = -5;

        long result = objCalcUnderTest.add(a, b);
        Assert.assertEquals(expectedResult, result);

    }

    @Test
    public void factorial() {
        long n = 19;
        long expectedResult = 121645100408832000L;
        long result = objCalcUnderTest.factorialUsingForLoop(n);
        Assert.assertEquals(expectedResult, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void tooBigNumberForFactorialMethod() {
        long n = 21;
        objCalcUnderTest.factorialUsingForLoop(n);

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
    @Test
    public void testRemainder() {
        int a = 13;
        int b = 4;
        int expectedResult = 1;
        int result = objCalcUnderTest.remainder(a, b);
        Assert.assertEquals(expectedResult, result);
    }


    @After
    public void after() {

        System.out.println("Jesli mnie widzisz znaczy ze to dzialanie jest poprawne :) ");

    }
}