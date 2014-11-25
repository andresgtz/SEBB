package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.*;

public class InterfazLogin extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlLogin ce;
  
   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Login</TITLE>");
    out.println("<h2>SEBB</h2>");
    //out.println("<h3>Loginr Saldo</h3>");
    out.println("<h3>Log in!</h3>");
    out.println("<p></p>");
    //out.println("<a href=\"menu.html\"> Regresar al menu principal </a>");
    out.println("</BODY>");
    out.println("</HTML>");    


    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarLogin();  
    }else if(operacion.equals("validar")){
      
    } 
  }



  public void iniciarLogin(){   
    out.println("<p>Indique el correo de la cuenta y contrase;a </p>");
    out.println("<form method=\"GET\" action=\"Login\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
    out.println("<p> Cuenta  <input type=\"text\" name=\"cuenta\" size=\"15\"></p>");
    out.println("<p> Constrasena <input type=\"text\" name=\"contrasena\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  

  public void validarCuenta(){  
    ce = new ControlLogin();
    //La funcion trim() elimina espacios antes y despues del valor
    String correo = thisRequest.getParameter("correo").trim();
    String contrasena = thisRequest.getParameter("contrasena").trim();
    boolean existente = ce.validarCuenta(correo,contrasena);
    if (existente){ 
      out.println("<form method=\"GET\" action=\"menu.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    } else {
       iniciarLogin();
    }
  }
}
