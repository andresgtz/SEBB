package entidades;
import java.sql.*;
import java.io.*;

public class Articulos{
Connection conn;
Statement stmt;

    public Articulos(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
    }

    public String getArticulo(int idArticulo) {
        String cont="";
       try {
         stmt.executeQuery ("SELECT contenido FROM Articulos WHERE idArticulo ="+ idArticulo);
         ResultSet rs = stmt.getResultSet(); 
         rs.next();
         cont = rs.getString("contenido");                      
         rs.close(); 
         return cont;
      } catch (SQLException x) {System.out.println("No se encontro el articulo " + x);}
        return cont;
    }

}
