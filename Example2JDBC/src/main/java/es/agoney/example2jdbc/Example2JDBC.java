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
        System.out.println("****************************************************************");
        System.out.println("Creando a Pepito Perez peperez@mail.com 1234-0987");
        System.out.println("************************************************************************");
        p = new Person("Pepito", "Perez", "peperez@mail.com", "1234-0987");
        p = new  PersonDAO().Create(p);
        System.out.println(p);
    }
}