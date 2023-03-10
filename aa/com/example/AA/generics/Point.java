package com.example.AA.generics;

public class Point<r,s>
{
    private r a;
    private s b;

    //
    public Point(r a,s b)
    {
        this.a=a;
        this.b=b;
    }

    //
    //
    public r getA(){return this.a;}
    public void setA(r a){this.a=a;}
    public s getB(){return this.b;}
    public void setB(s b){this.b=b;}

    //
    @Override
    public String toString()
    {
        return "a:"+this.a+";b:"+this.b+"\n";
    }

}