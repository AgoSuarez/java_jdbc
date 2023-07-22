package es.agoney.example1jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1JDBC {

    public static void main(String[] args) {
        try {
            //connection chain
            //no SSL connection => useSSL=false
            //We go to use a time zone => useTimezone=true
            //which Timezone to use => ServerTimezone=UTC
            //allowPublicKeyRetrieval=true
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&ServerTimezone=UTC&allowPublicKeyRetrieval=true";
            //not necesary but sometime is requiered
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "password";
            //Create the connection 
            Connection connection = DriverManager.getConnection(url, username, password);
            //Statement to execute queries
            Statement query = connection.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()){
                //by index
                //System.out.println("Id Person " + String.valueOf(rs.getInt(1)));
                //by name
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
