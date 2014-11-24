package entidades;
import java.sql.*;
import java.io.*;

public class Banco{
int id;
String nombre;
String email;
String telefono;
String direccion;
Connection conn;
Statement stmt;

    public void Banco(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }
    
    public void insertarBanco(int id, String nombre, String email, String telefono ,String direccion){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (id,nombre,email,telefono,direccion)" +
                   " VALUES ("+ id + " , '" + nombre + "', " + email + ", '"+ telefono + "', '"+ direccion+" )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }
}
