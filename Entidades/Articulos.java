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
         stmt.executeQuery ("SELECT nombre, fechaPublicacion, contenido FROM Articulos WHERE idArticulo ="+ idArticulo);
         ResultSet rs = stmt.getResultSet(); 
         rs.next();
         cont = rs.getString("nombre");
         cont += "<br>" + rs.getString("fechaPublicacion");
         cont += "<br>" + rs.getString("contenido");                      
         rs.close(); 
         return cont;
      } catch (SQLException x) {System.out.println("No se encontro el articulo " + x);}
        return cont;
    }

    public Boolean verificarArticulo(int idArticulo) {
        Boolean publicado = false;        
        try {
         stmt.executeQuery ("SELECT publicado FROM Articulos WHERE idArticulo ="+ idArticulo);
         ResultSet rs = stmt.getResultSet(); 
         rs.next();
         publicado = rs.getBoolean("publicado");                    
         rs.close(); 
         return publicado;
      } catch (SQLException x) {System.out.println("No se encontro el articulo " + x);}
        return publicado;
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

    public void publicarArticulo(int ida){
      try {
         String s = "UPDATE Articulos SET publicado = 1 WHERE idArticulo = " + ida;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot publish article" + e);}
    }

}
