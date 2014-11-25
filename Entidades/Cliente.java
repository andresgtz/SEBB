package entidades;
import java.sql.*;
import java.io.*;

public class Cliente{
String email;
String nombre;
String apellido;
String telefono;
String password;
String tipo;
boolean puedePublicar;
Connection conn;
Statement stmt;

    public Cliente(){
      System.out.println("prueba ");
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/SEBB";
            System.out.println("prueba URL");
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
            
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }
 
    public void publicarArticulo(int ida, String fecha){
      try {
         String s = "UPDATE articulo SET fechaPublicacion = " + fecha + " WHERE ncuenta = " + ida;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot publish article" + e);}
    }

    public void insertarArticulo(int idArticulo, int idRevista, String nombre, String autor, String fechaPublicacion, String clasificacion){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (idArticulo, idRevista, nombre, autor, fechaPublicacion, clasificacion)" + 
         " VALUES ("+ idArticulo + " , '" + idRevista + "', " + nombre + ", '"+ autor + "', '"+ fechaPublicacion + "',"+ "'"+clasificacion+" )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
    }

    public void renovarSuscripcion(int sid){
    //SQL QUERY
    try {
            String s = "UPDATE SUSCRIPCIONES SET fechaExpiracion=DATE_ADD(fechaExpiracion, INTERVAL 1 YEAR) WHERE ID=" + sid;
            System.out.println(s);
            stmt.executeUpdate(s);
        }catch (Exception e) { System.out.println ("Cannot renew suscription." + e ); }  
    }

    public void pagarSuscripcion(int sid){
      try {
        String s = "Pagar suscripcion con id " + sid;
        System.out.println(s);
      }catch (Exception e) { System.out.println ("Cannot pay suscription" + e ); }
    }

    public void cancelarSuscripcion(int sid){
        try {
            String s = "DELETE FROM SUSCRIPCIONES WHERE ID=" + sid;
            System.out.println(s);
            stmt.executeUpdate(s);
        }catch (Exception e) { System.out.println ("Cannot cancel suscription" + e ); }  
    }

    public void agregarCliente(String email, String nombre,String apellido, String telefono,String password){
    //SQL QUERY
        System.out.println("si jala");
        try {
         String s = "INSERT INTO CLIENTES (email, nombre, apellido, telefono, password)" +
                   " VALUES ('"+ email + "', '" + nombre + "', '" + apellido + "', '" + telefono + "', '" + password + "')";
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

