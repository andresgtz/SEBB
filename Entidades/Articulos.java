package entidades;
import java.sql.*;
import java.io.*;

public class Articulos{
int idArticulo;
int idRevista;
String nombre;
String autor;
String fechaPublicacion;
String clasificacion;
Connection conn;
Statement stmt;

    public void Articulos(){
        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }
    
    public void insertarArticulo(int idArticulo, int idRevista, String nombre, String autor ,String fechaPublicacion, String clasificacion){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (idArticulo, idRevista, nombre, autor, fechaPublicacion, clasificacion)" + 
         " VALUES ("+ idArticulo + " , '" + idRevista + "', " + nombre + ", '"+ autor + "', '"+ fechaPublicacion + "',"+ "'"+clasificacion+" )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }
}
