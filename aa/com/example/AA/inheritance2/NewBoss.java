package com.example.AA.inheritance2;

public class NewBoss extends NewPerson
{
    private String company;
    public NewBoss(String name, String address, String company)
    {
        super(name,address);
        this.company=company;
    }

    public  String show()
    {
        return "Boss";
    }

}
