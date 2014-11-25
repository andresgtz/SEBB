package entidades;
import java.sql.*;
import java.io.*;

public class Revistas{
Connection conn;
Statement stmt;

    public Revistas(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }    

    public void insertarRevista(int idRevista, String titulo, int numeroVolumen, String ISSN){
    //SQL QUERY

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");


        String currentTime = sdf.format(dt);

        System.out.println(currentTime);

        try {
         String s = "INSERT INTO Revistas (idRevista,titulo,numeroVolumen,ISSN ,fechaPublicacion)" +
                   " VALUES ("+ idRevista + " , '" + titulo + "', " + numeroVolumen + ", '"+ ISSN + "', '"+ currentTime+"' )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }
}

