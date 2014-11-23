package entidades;
import java.sql.*;
import java.io.*;

public class Cuenta {
   Connection conn;
   Statement stmt;

   public Cuenta(){
      try {
        String userName = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost/cajero";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }

   public boolean validar(int ncuenta){
      try {
         stmt.executeQuery ("SELECT ncuenta FROM cuenta WHERE ncuenta = " + ncuenta);
         ResultSet rs = stmt.getResultSet(); 
         if (rs.next()) { //Va al primer registro si lo hay
            int nCuenta = rs.getInt ("ncuenta");                      
            rs.close(); 
            return( ncuenta == nCuenta );
         }else{ return false;}
      } catch (SQLException e) {System.out.println("Excepcion en validar " + e);}
      return false;
   }
      
   public void agregar(int ncuenta, String nombre, float saldo){
      try {
         String s = "INSERT INTO CUENTA (ncuenta, nombre, saldo)" +
                   " VALUES ("+ ncuenta + " , '" + nombre + "', " + saldo + " )";
         System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }    
   
   public void setSaldo(int ncuenta, float saldo){
      try {
         String s = "UPDATE cuenta SET saldo = " + saldo + " WHERE ncuenta = " + ncuenta;
         stmt.executeUpdate(s);
      } catch (SQLException e) {System.out.println ("Cannot execute disposicion()" + e);}
   }

   public float getSaldo(int ncuenta){
      float saldo = 0.0f; 
      try {
         stmt.executeQuery ("SELECT saldo FROM cuenta WHERE ncuenta = " +ncuenta);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         saldo = rs.getFloat("saldo");
         rs.close();
         return(saldo);
      } catch (SQLException e) {System.out.println ("Cannot getSaldo()" + e);}
      return saldo;
   }
   
}
