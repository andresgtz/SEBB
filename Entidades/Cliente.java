/*
CHEAT SHEET

tipo: tipo que eres
    0 = suscriptor
    1 = autor
    2 = juez
    3 = admin/editorJefe
*/

package entidades;
import java.sql.*;
import java.io.*;

public class Cliente{
String email;
String nombre;
String apellido;
String telefono;
String password;
int tipo;
boolean puedePublicar;
boolean suscripcion;
Connection conn;
Statement stmt;

    public Cliente(){
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

    public void agregarCliente(String usuario, String nombre, String apellido, String telefono, String password, int tipo){
    //SQL QUERY
        try {
           String s = "INSERT INTO CLIENTES (email, nombre, apellido, telefono, password, tipo)" +
                   " VALUES ('"+ usuario + "', '" + nombre + "', '" + apellido + "', '" + telefono + "', '" + password + "', " + tipo + ")";
           System.out.println(s);
           stmt.executeUpdate(s);
        }catch (Exception f) { System.out.println ("Cannot update database" + f ); }  
    }

    public int getUserId(String e) {
        int id = 1;        
        try {
         stmt.executeQuery ("SELECT idCliente FROM Clientes WHERE email ='"+ e+"'");
         ResultSet rs = stmt.getResultSet(); 
         rs.next();
         id = rs.getInt("idCliente");                    
         rs.close(); 
         return id;
      } catch (SQLException x) {System.out.println("No se encontro el usuario " + x);}
        return id;
    }

    public int getUserType(String e) {
        int tipo = 0;        
        try {
         stmt.executeQuery ("SELECT tipo FROM Clientes WHERE email ='"+ e+"'");
         ResultSet rs = stmt.getResultSet(); 
         rs.next();
         tipo = rs.getInt("tipo");                    
         rs.close(); 
         return tipo;
      } catch (SQLException x) {System.out.println("No se encontro el usuario " + x);}
        return tipo;
    }
    
    public void eliminarCliente(String e){
    //SQL QUERY
        try {
         String s = "DELETE FROM CLIENTES WHERE email='" + e +"'";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception g) { System.out.println ("Cannot update database" + g ); }  
        
    }

    public Boolean validar(String e,String p){
    //VALIDACION LOGIN
      String nE="";
       try {
         stmt.executeQuery ("SELECT email FROM CLIENTES WHERE email = '" + e +"' and password = '"+p+"'");
         ResultSet rs = stmt.getResultSet(); 
         rs.next(); //Va al primer registro si lo hay
         nE = rs.getString("email");                     
         rs.close(); 
         System.out.println("-"+e + "=+=" + nE + "-" );
         return( nE != "" );
        }catch (SQLException x) {System.out.println("Excepcion en validar " + x);}
      return false;
        
    }
}

