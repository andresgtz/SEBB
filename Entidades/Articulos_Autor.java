package entidades;
import java.sql.*;
import java.io.*;

public class Articulos_Autor{
Connection conn;
Statement stmt;

    public void Articulos_Autor(){
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost/SEBB";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection (url, userName, password);
            stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
  }
}
