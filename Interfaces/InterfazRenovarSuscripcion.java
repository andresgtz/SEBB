package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlPublicarArticulo;

public class InterfazPublicarArticulo extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlPublicarArticulo cr;

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
    } else if(operacion.equals("renovarSuscripcion")){
      publicarArticulo();
    }

  }

  public void pedirDatos(){
    out.println("<p>Indique los datos del articulo</p>");
    out.println("<form method=\"GET\" action=\"renovarSuscripcion\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"renovarSuscripcion\"/>");
    out.println("<p> ID del Cliente  <input type=\"text\" name=\"idCliente\" value="+getCurrentUser()+"size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Renovar\"name=\"B1\"></p>");
    out.println("</form>");

    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void renovarSuscripcion() {
    cr = new ControlRenovarSuscripcion();

    int idCliente = Integer.parseInt(thisRequest.getParameter("idCliente").trim());

    cr.renovarSuscripcion(idCliente);

    out.println("<p>La suscripcion del cliente: " + idCliente +  " fue renovada.</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</BODY>");
    out.println("</HTML>");
  }

}

