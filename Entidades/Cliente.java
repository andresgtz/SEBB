package entidades;
import java.sql.*;
import java.io.*;

public class Cliente{
String email;
String nombre;
String apellido;
String telefono;
String password;
Connection conn;
Statement stmt;

    public void Cliente(){
        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }

    public void agregarCliente(String email, String nombre,String apellido, String telefono,String password){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (email, nombre, apellido, telefono, password)" +
                   " VALUES ("+ email + " , '" + nombre + "', " + apellido + ", '"+ telefono + "', '"+ password + "' )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception f) { System.out.println ("Cannot update database" + f ); }  
        
    }
    
    public void eliminarCliente(String e){
    //SQL QUERY
        try {
         String s = "DELETE FROM CLIENTES WHERE email='" + e+"'";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception g) { System.out.println ("Cannot update database" + g ); }  
        
    }

    public Boolean validar(String e,String p){
    //SQL QUERY
       try {
         stmt.executeQuery ("SELECT email FROM cuenta WHERE email = " + e +" and password = "+p);
         ResultSet rs = stmt.getResultSet(); 
         if (rs.next()) { //Va al primer registro si lo hay
            String nE = rs.getString("email");                      
            rs.close(); 
            return( e == nE );
         }else{ return false;}
      } catch (SQLException x) {System.out.println("Excepcion en validar " + x);}
      return false;
        
    }
}

