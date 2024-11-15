package main;

class solution5 
{
    public double power(double base, int exponent) 
    {
        return exponent >= 0 ? calculatePower(base, exponent) : 1 / calculatePower(base, -(long) exponent);
    }

    private double calculatePower(double base, long exponent) 
    {
        double result = 1;
        
        while (exponent > 0) 
        {
            if ((exponent & 1) == 1) 
            {
                result = result * base;
            }
            base = base * base;
            exponent >>= 1;
        }
        
        return result;
    }
}
