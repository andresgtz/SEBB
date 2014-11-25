package entidades;
import java.sql.*;
import java.io.*;

public class Suscripciones{
int id;
String email;
char tipo;
String fechaInicio;
String fechaExpiracion;
double precio;
Connection conn;
Statement stmt;

    public Suscripciones(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
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
}
