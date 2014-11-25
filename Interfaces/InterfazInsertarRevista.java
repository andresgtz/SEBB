package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlInsertarRevista;

public class InterfazInsertarRevista extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlInsertarRevista cr;
  
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
    out.println("<script src='//code.jquery.com/jquery-2.1.1.min.js'></script>");//h
    out.println("<link href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css' rel='stylesheet'>");//h
    out.println("<script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js'></script>");//h
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<div class='jumbotron'>");//o
    out.println("<div class='container' style='text-align: center;'>");//o
    out.println("<TITLE>SEBB</TITLE>");
    out.println("<h1>Revista</h1>");
    out.println("<h3>Crear</h3>");

    String operacion = request.getParameter("operacion");
    if(operacion == null){
      pedirDatos();
    } else if(operacion.equals("insertarRevista")){
      insertarRevista();
    }

  }

  public void pedirDatos(){
    out.println("<p>Indique los siguientes datos para agregar una revista</p>");
    out.println("<form method=\"GET\" action=\"InsertarRevista\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"insertarRevista\"/>");
    out.println("<p> Titulo  <input type=\"text\" name=\"titulo\" size=\"15\"></p>");
    out.println("<p> Volumen  <input type=\"text\" name=\"numeroVolumen\" size=\"15\"></p>");
    out.println("<p> ISSN  <input type=\"text\" name=\"issn\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Registrar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");    
  }

  public void insertarRevista() {
    cr = new ControlInsertarRevista();
    String salida = "";
    
    String titulo = thisRequest.getParameter("titulo");
    int numeroVolumen = Integer.parseInt(thisRequest.getParameter("numeroVolumen").trim());
    String issn = thisRequest.getParameter("issn");
    
    cr.InsertarRevista(titulo, numeroVolumen, issn);
    
    out.println("<p>¡Revista creada correctamente!</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>"); 
  }
  
}


