package entidades;
import java.sql.*;
import java.io.*;

public class Revistas{
Connection conn;
Statement stmt;

    public void Revistas(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }    

    public void insertarRevista(int idRevista, String titulo, int numeroVolumen, String ISSN ,String fechaPublicacion){
    //SQL QUERY
        try {
         String s = "INSERT INTO CLIENTES (idRevista,titulo,numeroVolumen,ISSN ,fechaPublicacion)" +
                   " VALUES ("+ idRevista + " , '" + titulo + "', " + numeroVolumen + ", '"+ ISSN + "', '"+ fechaPublicacion+" )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }
}

