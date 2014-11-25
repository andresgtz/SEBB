package entidades;
import java.sql.*;
import java.io.*;

public class Articulos{
Connection conn;
Statement stmt;

    public void Articulos(){
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
       try {
         stmt.executeQuery ("SELECT contenido FROM Articulos WHERE idArticulo ="+ idArticulo);
         ResultSet rs = stmt.getResultSet(); 
         return rs;
      } catch (SQLException x) {System.out.println("No se encontro el articulo " + x);}
    }

    public void insertarArticulo(int idRevista, String nombre, String contenido, String clasificacion){
    //SQL QUERY
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");


        String currentTime = sdf.format(dt);

        System.out.println(currentTime);

        try {
         String s = "INSERT INTO ARTICULOS " + 
         " VALUES (NULL, '" + idRevista + "', '" + nombre + "', 0, '"+contenido+"', '"+ currentTime + "',"+ "'"+clasificacion+"', 0)";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
    }

}
