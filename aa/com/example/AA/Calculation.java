package com.example.AA;

public class Calculation
{
    public double divide(double v1,double v2) throws InputException
    {
        if(v1<0)
        {
            throw new InputException("v1 cannot be negative! ");
        }
        if(v2<0)
        {
            throw new InputException("v2 cannot be negative! ");
        }
        if(v2==0)
        {
            throw new InputException("v2 cannot be zero! ");
        }
        return v1/v2;
    }

    public static <T extends Number>T add(T x,T y)
    {
        Integer r;
        r=x.intValue()+y.intValue();
        return (T)r;
    }
}
