package es.agoney.example2jdbc;

import database.PersonDAO;
import domain.Person;
import java.util.List;

public class Example2JDBC {

    public static void main(String[] args) {
        List<Person> persons = new PersonDAO().getAll();
        for(Person p: persons){
            System.out.println(p);
        }
        System.out.println("***************************************************************");
        Person p = new PersonDAO().getById(3);
        System.out.println("By Id " + p);
/*        System.out.println("****************************************************************");
        System.out.println("Creatinf a Pepito Perez peperez@mail.com 1234-0987");
        System.out.println("************************************************************************");
        p = new Person("Pepito", "Perez", "peperez@mail.com", "1234-0987");
        p = new  PersonDAO().ureate(p);
        System.out.println(p);*/
        System.out.println("**********************************************************************");
        /*p=new Person(6,"Fulano", "Talycual", "ftal@mail.com", "0000-1111");
        int result = new PersonDAO().update(p);
        System.out.println("Update " + result + " registers");
        System.out.println(new PersonDAO().getById(6));*/
        System.out.println("---------- BEFORE DELETE 6 -------------");
        persons = new PersonDAO().getAll();
        for(Person pe: persons){
            System.out.println(pe);
        }
        System.out.println("***************************************************************");
        p=new Person(6);
        int result=new PersonDAO().delete(p);
        if (result==1) System.out.println("Se borro el elemento 6");
                System.out.println("---------- AFTER DELETE 6 -------------");
        persons = new PersonDAO().getAll();
        for(Person pe: persons){
            System.out.println(pe);
        }
        System.out.println("***************************************************************");
    }
}