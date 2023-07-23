package database;

import domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_SELECT_BY_ID = "SELECT id_persona, nombre, apellido, email, telefono FROM persona WHERE id_persona=?";

    public List<Person> getAll() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Person> persons = new ArrayList<>();
        try {
            conn = ConnectionDB.getConnection();
            stm = conn.prepareStatement(SQL_SELECT);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String name = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                String email = rs.getString("email");
                String phone = rs.getString("telefono");
                Person person = new Person(idPersona, name, lastName, email, phone);
                persons.add(person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(stm);
                ConnectionDB.close(rs);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return persons;
    }

    public Person getById(int id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Person person = null;
        try {
            conn = ConnectionDB.getConnection();
            stm = conn.prepareStatement(SQL_SELECT_BY_ID);
            stm.setInt(1, 3);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String name = rs.getString("nombre");
                String lastName = rs.getString("apellido");
                String email = rs.getString("email");
                String phone = rs.getString("telefono");
                person = new Person(idPersona, name, lastName, email, phone);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConnectionDB.close(stm);
                ConnectionDB.close(rs);
                ConnectionDB.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return person;
    }

    
}
