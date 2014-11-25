package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.*;

public class InterfazInsertarArticulo extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlInsertarArticulo cr;
  
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
    out.println("<p> ID Articulo  <input type=\"text\" name=\"idArticulo\" size=\"15\"></p>");
    out.println("<p> ID Revista  <input type=\"text\" name=\"idRevista\" size=\"15\"></p>");
    out.println("<p> Nombre  <input type=\"text\" name=\"nombre\" size=\"15\"></p>");
    out.println("<p> Autor  <input type=\"text\" name=\"autor\" size=\"15\"></p>");
    out.println("<p> Fecha  <input type=\"text\" name=\"fecha\" size=\"15\"></p>");
    out.println("<p> Clasificacion  <input type=\"text\" name=\"clasificacion\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Registrar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }

  public void insertarArticulo() {
    cr = new ControlInsertarArticulo();
    String salida = "";
    
    int idArticulo = Integer.parseInt(thisRequest.getParameter("idArticulo").trim());
    int idRevista = Integer.parseInt(thisRequest.getParameter("idRevista").trim());
    String nombre = thisRequest.getParameter("nombre");
    String autor = thisRequest.getParameter("autor");
    String fecha = thisRequest.getParameter("fecha");
    String clasificacion = thisRequest.getParameter("clasificacion");
    
    cr.insertarArticulo(idArticulo, idRevista, nombre, autor, fecha, autor, clasificacion);
    
    out.println("<p>¡Articulo añadido correctamente!</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</BODY>");
    out.println("</HTML>"); 
  }
  
}


