package com.example.AA.inheritance;

public class Person
{
    //
    private String name;
    private String address;

    //
    public Person(String name,String address)
    {
        this.name=name;
        this.address=address;
    }
    public Person(String name)
    {
        this.name=name;
    }

    public String show()
    {
        return "Person";
    }

    public String show2()
    {
        return "Person";
    }
}
