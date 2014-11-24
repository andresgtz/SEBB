package entidades;
import java.sql.*;
import java.io.*;

public class Pagos{
int id;
int idBanco;
String email;
String fecha;
double cantidad;
String detalle;
Connection conn;
Statement stmt;

    public void Pagos(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }
    
    public void insertarPago(int id, int idBanco, String email, String fecha ,double cantidad, String detalle){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (id, idBanco, email, fecha, cantidad, detalle)" +
                   " VALUES ("+ id + " , '" + idBanco + "', " + email + ", '"+ fecha + "', '"+ cantidad + "',"+ "'"+detalle+" )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }
}
