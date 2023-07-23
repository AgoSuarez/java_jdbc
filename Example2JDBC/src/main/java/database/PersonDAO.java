package database;

import domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_SELECT_BY_ID = "SELECT id_persona, nombre, apellido, email, telefono FROM persona WHERE id_persona=?";
    private static final String SQL_INSERT="INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    
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

    public Person Create(Person person) {
        Connection conn = null;
        PreparedStatement stm = null;
        int affectedRows = 0;
        
        try {
            conn=ConnectionDB.getConnection();
            stm=conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, person.getName());
            stm.setString(2, person.getLastName());
            stm.setString(3, person.getEmail());
            stm.setString(4, person.getPhone());
            affectedRows=stm.executeUpdate();
            if (affectedRows == 1){
                try (ResultSet generatedKeys = stm.getGeneratedKeys()){
                    if (generatedKeys.next()) {
                            person.setIdPerson(generatedKeys.getInt(1));
                        }
                }catch (SQLException ex){
                    ex.printStackTrace(System.out);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person;
    }
}
