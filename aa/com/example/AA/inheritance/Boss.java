package com.example.AA.inheritance;

public class Boss extends Person
{
    private String company;
    public Boss(String name,String address,String company)
    {
        super(name,address);
        this.company=company;
    }

    //
    public String show()
    {
        return "Boss";
    }
}
