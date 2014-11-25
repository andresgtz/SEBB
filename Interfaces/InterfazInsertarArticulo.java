package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlInsertarArticulo;

public class InterfazInsertarArticulo extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlInsertarArticulo cr;
  int idAutor;

  
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
    out.println("<h1>Articulo</h1>");
    out.println("<h3>Crear</h3>");

    idAutor = Integer.parseInt(thisRequest.getParameter("idUsuario").trim());

    String operacion = request.getParameter("operacion");
    if(operacion == null){
      pedirDatos();
    } else if(operacion.equals("insertarArticulo")){
      insertarArticulo();
    }

  }

  public void pedirDatos(){
    out.println("<p>Indique los siguientes datos para insertar un articulo</p>");
    out.println("<form method=\"GET\" action=\"InsertarArticulo\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"insertarArticulo\"/>");
    out.println("<p> ID Revista  <input type=\"text\" name=\"idRevista\" size=\"15\"></p>");
    out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + idAutor + "\"/>");
    out.println("<p> Titulo  <input type=\"text\" name=\"nombre\" size=\"15\"></p>");
    out.println("<p> Contenido  <input type=\"textarea\" name=\"contenido\"></p>");
    out.println("<p> Clasificacion  <input type=\"text\" name=\"clasificacion\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Registrar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");    
  }

  public void insertarArticulo() {
    cr = new ControlInsertarArticulo();
    String salida = "";
    
    int idRevista = Integer.parseInt(thisRequest.getParameter("idRevista").trim());
    String nombre = thisRequest.getParameter("nombre");
    String contenido = thisRequest.getParameter("contenido");
    String clasificacion = thisRequest.getParameter("clasificacion");
    
    cr.InsertarArticulo(idRevista, idAutor, nombre, contenido, clasificacion);
    
    out.println("<p>¡Articulo creado correctamente!</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>"); 
  }
  
}


