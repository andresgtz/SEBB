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
    
    public void votar(int idArticulo) {
      try {
        stmt.executeQuery ("SELECT votos FROM Articulos WHERE idArticulo =" + idArticulo);
        ResultSet rs = stmt.getResultSet();
        int votos = rs.getInt ("votos");
        votos = votos + 1;
        String s = "UPDATE Articulos SET votos = " + votos + " WHERE idArticulo = " + idArticulo;
        stmt.executeQuery (s);
      } catch (SQLException e) {System.out.println ("Cannot vote for the article" + e);}
    }

}
