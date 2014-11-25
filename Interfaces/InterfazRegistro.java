package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlRegistro;

public class InterfazRegistro extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlRegistro cr;
  
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>SEBB</TITLE>");
    out.println("<h1>Revista</h1>");
    out.println("<h3>Registro</h3>");

    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de un registro
      iniciarRegistro();  
    } else if(operacion.equals("registrar")){
      registrarSuscriptor();
    }

  }

  public void iniciarRegistro(){  
    out.println("<p>Indique los siguientes datos para su suscripcion</p>");
    out.println("<form method=\"GET\" action=\"Registro\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"registrar\"/>");
    out.println("<p> Email  <input type=\"text\" name=\"email\" size=\"15\"></p>");
    out.println("<p> Nombre  <input type=\"text\" name=\"nombre\" size=\"15\"></p>");
    out.println("<p> Apellido  <input type=\"text\" name=\"apellido\" size=\"15\"></p>");
    out.println("<p> Telefono  <input type=\"text\" name=\"telefono\" size=\"15\"></p>");
    out.println("<p> Password <input type=\"text\" name=\"password\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Registrar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }

  public void registrarSuscriptor() {
   
     out.println("<p>DOES IT WORK?!?</p>");
    cr = new ControlRegistro();

    String email = thisRequest.getParameter("email").trim();
    String nombre = thisRequest.getParameter("nombre").trim();
    String apellido = thisRequest.getParameter("apellido").trim();
    String telefono = thisRequest.getParameter("telefono").trim();
    String password = thisRequest.getParameter("password").trim();
    int tipo = Integer.parseInt(thisRequest.getParameter("tipo").trim());

    out.println("<p>Su registro fue exitoso, " + nombre +  ". Gracias por suscribirse a nuestra revista.</p>");
    
    cr.agregarCliente(email, nombre, apellido, telefono, password, tipo);
    
    out.println("<p>Presione el boton para1 terminar.</p>");
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</BODY>");
    out.println("</HTML>"); 
  }
  
}
