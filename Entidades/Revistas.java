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

    public void insertarRevista(String titulo, int numeroVolumen, String ISSN){
    //SQL QUERY

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");


        String currentTime = sdf.format(dt);

        System.out.println(currentTime);

        try {
         String s = "INSERT INTO Revistas" +
                   " VALUES ( NULL , '" + titulo + "', " + numeroVolumen + ", '"+ ISSN + "', '"+ currentTime+"' )";
         System.out.println(s);
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }  
        
    }

    public String verArticulos(int idRevista) {
      int idArticulo;
      String nombre = "";
      String resultado = "";
      try {
        stmt.executeQuery ("SELECT idArticulo, nombre FROM Articulos WHERE idRevista ="+ idRevista);
        ResultSet rs = stmt.getResultSet(); 
        System.out.println("<ul>");
        while(rs.next()){
        idArticulo = rs.getInt("idArticulo");
          nombre = rs.getString("nombre"); 
          resultado+="<li> id: "+idArticulo+" nombre: " + nombre + "</li> ";
        }
        System.out.println("</ul>");                  
        rs.close(); 
         
      } catch (SQLException x) {System.out.println("No se encontro el articulo " + x);}
      return resultado;
    }
}

