package com.example.AA;

import com.example.AA.generics.Point;
import com.example.AA.inheritance.Boss;
import com.example.AA.inheritance.Person;
import com.example.AA.inheritance2.NewBoss;
import com.example.AA.inheritance2.NewPerson;
import com.example.AA.inheritance3.NewNewBoss;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.AA.Calculation.add;

public class Main
{
//    public enum Day
//    {
//        Mondayy
//    }
    public static void main(String[] ss)
    {
        //1
        int[] a=new int[10];
        Arrays.fill(a,-1);a[0]=-2;
        System.out.println(Arrays.toString(a));System.out.println();
        //2
        int[][]  da=new int[2][10];
        Arrays.stream(da).forEach(v->Arrays.fill(v,-1));da[0][0]=-2;
        System.out.println(Arrays.deepToString(da));System.out.println();
        //
        Set<Student> s=new HashSet<>(Arrays.asList(new Student("Aaron","200 Rd"),new Student("Bob","200 Rd")));
        Student student=new Student("Aaron","200 Rd");
        System.out.println(s.remove(student ));
        System.out.println("2:"+s);System.out.println();

        //3
        Map<String,Integer> m=new HashMap<>(){{put("ab",1);put("cd",2);}};
        System.out.println(m);System.out.println(m.keySet());System.out.println(m.values());System.out.println();
        System.out.println("3:"+m.getOrDefault(1,null));System.out.println();
        m.put("df",3);System.out.println(m);
        m.remove("cd");System.out.println(m);
        //4
        StringBuilder d=new StringBuilder("abcd");
        d.insert(1,"00");d.append(2);
        System.out.println(d);System.out.println();

        //5
        StringBuffer f=new StringBuffer("abcd");
        f.insert(1,"00");f.append(2);
        System.out.println(f);System.out.println();

        //6
        Calculation calculation =new Calculation();
        double vv=0;
        try
        {
            vv= calculation.divide(1,0);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(vv);System.out.println();


//        //
//        List list=new LinkedList(Arrays.asList(1,'a',"ab"));
//        System.out.println(list);System.out.println();

        //7
        List<Student> listStudent=new LinkedList<>(Arrays.asList(
                new Student("Kim","road"),new Student("Tim","way"),new Student("Kim","way")
        ));
        //1).ascending
        Collections.sort(listStudent);
        System.out.println(listStudent);
        //2).ascending
        Collections.sort(listStudent,(v1,v2)->{
            if(v1.getName().compareTo(v2.getName())>0) return 1;
            else if(v1.getName().compareTo(v2 .getName())<0) return -1;

            return v1.getAddress().compareTo(v2.getAddress());
        });
        System.out.println(listStudent);
        //3).ascending
        Collections.sort(listStudent,new Comparator<Student>(){
                public int compare(Student v1,Student v2)
                {
                    if(v1.getName().compareTo(v2.getName())>0) return 1;
                    else if(v1.getName().compareTo(v2 .getName())<0) return -1;

                    return v1.getAddress().compareTo(v2.getAddress());
                }
        });
        System.out.println(listStudent);
        //4).ascending
        listStudent=listStudent.stream().sorted( (v1,v2)->{
            if(v1.getName().compareTo(v2.getName())>0) return 1;
            else if(v1.getName().compareTo(v2 .getName())<0) return -1;

            return v1.getAddress().compareTo(v2.getAddress());
        }).collect(Collectors.toList());
        System.out.println(listStudent);System.out.println();


        //8
        List<Integer> li=new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        //1)
        li=li.stream().filter(v->v%2==0).collect(Collectors.toList());
        System.out.println(li);
        //2)
        li.stream().forEach(v->System.out.print(v));System.out.println();
        //3)
        li=li.stream().map(v-> v=v+1).collect(Collectors.toList());
        System.out.println(li);
        //4)
        System.out.println(li.stream().min((v1,v2)->v1-v2).get());

        //9
        String string="a. bA12cB;3#@#d";
        string=string.replaceAll("[^a-z0-9A-Z]","");
        System.out.println(string);System.out.println();

        //
        Iterator it=li.iterator();
        for(;it.hasNext();)
        {
            System.out.print(it.next());
        }
        System.out.println();System.out.println();

        //
        Person person=new Person("Aarron","200 Rd");
        System.out.println(person.show());System.out.print(person.show2());System.out.println();
        Boss boss=new Boss("Aaron","200 Rd","Apple");
        System.out.println(boss.show());System.out.println(boss.show2());System.out.println();

        //
        NewPerson newperson=new NewBoss("Aaron","200 Rd","Apple");
        System.out.println(newperson.show());System.out.println(newperson.show2());System.out.println();
        System.out.println(newperson.show());System.out.println();

        //
        NewNewBoss newNewBoss=new NewNewBoss();
        System.out.println(newNewBoss.show2());

        //
        com.example.AA.Day day=Day.Monday;
        System.out.println();
        for(Day dayy:Day.values())
        {
            System.out.println(dayy.toString());
        }
        System.out.println(Day.values()[0].getClass().getName());
        System.out.println(day.getClass().getName());
        System.out.println (Day.valueOf("Monday"));
    }
}
