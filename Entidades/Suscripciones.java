package entidades;
import java.sql.*;
import java.io.*;

public class Suscripciones{
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
        java.util.Date dt = new java.util.Date();
        java.util.Date expirationDate = new java.util.Date();
        int year = expirationDate.getYear();
        year = (year + 1);
        expirationDate.setMonth(year);

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sexpirationDate = new java.text.SimpleDateFormat("yyyy-MM-dd");

        String currentTime = sdf.format(dt);
        String expirationTime = sexpirationDate.format(expirationDate);

        System.out.println(currentTime);
        System.out.println(expirationDate);

        try {   
                String s = "INSERT INTO SUSCRIPCIONES " + 
                " VALUES (NULL, " + sid + ", 0, '"+currentTime+"', '"+ expirationTime + "', 99.99)";
                System.out.println(s);
                stmt.executeUpdate(s);
            }catch (Exception e) { System.out.println ("Cannot renew suscription." + e ); }  
    }

    
    public void cancelarSuscripcion(int sid){
        try {
            String s = "DELETE FROM SUSCRIPCIONES WHERE ID=" + sid;
            System.out.println(s);
            stmt.executeUpdate(s);
        }catch (Exception e) { System.out.println ("Cannot cancel suscription" + e ); }  
    }

}
