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
    out.println("<form method=\"GET\" action=\"Registrar\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"registrar\"/>");
    out.println("<p> Nombre  <input type=\"text\" name=\"nombreS\" size=\"15\"></p>");
    out.println("<p> ID  <input type=\"text\" name=\"idS\" size=\"15\"></p>");
    out.println("<p> Direccion  <input type=\"text\" name=\"dirS\" size=\"15\"></p>");
    out.println("<p> Telefono  <input type=\"text\" name=\"telS\" size=\"15\"></p>");
    out.println("<p> Tipo de suscripcion  <input type=\"text\" name=\"tipoS\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Registrar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }

  public void registrarSuscriptor() {
    cr = new ControlRegistro();
    String email = thisRequest.getParameter("nombreS").trim();
    String id = Integer.parseInt(thisRequest.getParameter("idS").trim());
    String dir = thisRequest.getParameter("dirS");
    String tel = Integer.parseInt(thisRequest.getParameter("telS").trim());
    String tipo = thisRequest.getParameter("tipoS").trim();
    
    cr.agregarSuscriptor(nombre, id, dir, tel, tipo);
    
    out.println("<p>Su registro fue exitoso, " + nombre +  ". Gracias por suscribirse a nuestra revista.</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</BODY>");
    out.println("</HTML>"); 
  }
  
}
