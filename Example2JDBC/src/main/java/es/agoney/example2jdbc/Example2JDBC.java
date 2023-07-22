/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.agoney.example2jdbc;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author suare
 */
public class Example2JDBC {

    public static void main(String[] args) {
       try {
            Connection conn = ConnectionDB.getConnection();
            Statement query = conn.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()){
                System.out.println("Id Person " + String.valueOf(rs.getInt("id_persona")));
                System.out.println("Name " + rs.getString("nombre"));
                System.out.println("Lastname " + rs.getString("apellido"));
                System.out.println("email " + rs.getString("email")); 
                System.out.println("Phone" + rs.getString("telefono"));
                System.out.println("----------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
