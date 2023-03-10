package com.example.AA.inheritance2;

public abstract class NewPerson
{
    //
    private String name;
    private String address;

    //
    public NewPerson(String name, String address)
    {
        this.name=name;
        this.address=address;
    }

    public abstract String show();
    public String show2()
    {
        return "Person";
    }
}
