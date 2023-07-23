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
    }
}
