public class Calculator {
//checklab23
    public Calculator() {
    }
/*check something for lab5*/
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }


    public long multiply(long a, long b) {
        return a * b;
    }


    public double divide(double a, double b) {
        double result;
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot divide by zero");
        } else {
            result = a/b;
        }
        return result;
    }

    public long factorialUsingForLoop(long n) {
        long fact = 1;
        if (n > 20) {
            throw new IllegalArgumentException("To big number for long type");
        }else
            for (long i = 2; i <= n; i++) {
                fact = fact * i;
            }

            return fact;
        }


    public int remainder(int a, int b) {return a % b;}

    public float exponentiation(float a, float b)
    {
        float base=a;
        float power=b;
        int result=1;
        if(power!=0){
            for(int i=1;i<=power;i++)
            {
                result*=base;
            }
        }else if(power == 0) {
            throw new IllegalArgumentException("Wrong number!!!!");
        }
        return result;
        }
    }





