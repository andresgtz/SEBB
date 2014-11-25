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
}
