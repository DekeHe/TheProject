package com.example.AA;

public class Student implements Comparable<Student>
{
    //
    private String name;
    private String address;

    //
    public Student(String name,String address)
    {
        this.name=name;
        this.address=address;
    }

    //
    public String getName(){return this.name;}
    public void setName(String name){this.name=name;}
    public String getAddress(){return this.address;}
    public void setAddress(String address){this.address=address;}


    //
    @Override
    public String toString()
    {
        return
                "name:"+this.name+";address:"+this.address+"\n";
    }

    @Override
    public int compareTo(Student anotherStudent)
    {
        if(this.getName().compareTo(anotherStudent.getName())>0) return 1;
        else if(this.getName().compareTo(anotherStudent .getName())<0) return -1;

        return this.getAddress().compareTo(anotherStudent.getAddress());
    }
}
