package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlRenovarSuscripcion;

public class InterfazRenovarSuscripcion extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlRenovarSuscripcion cr;
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
    out.println("<h1>SEBB</h1>");
    out.println("<h3>Crear Suscripcion</h3>");


    idAutor = Integer.parseInt(thisRequest.getParameter("idUsuario").trim());

    String operacion = request.getParameter("operacion");
    if(operacion == null){
      pedirDatos();
    } else if(operacion.equals("renovarSuscripcion")){
      renovarSuscripcion();
    }

  }

  public void pedirDatos(){
    out.println("<p>Indique los datos del articulo</p>");
    out.println("<form method=\"GET\" action=\"RenovarSuscripcion\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"renovarSuscripcion\"/>");
    out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + idAutor + "\"/>");

    out.println("<p><input type=\"submit\" value=\"Renovar\"name=\"B1\"></p>");
    out.println("</form>");

    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void renovarSuscripcion() {
    out.println("<p>La suscripcion del cliente:.</p>");

    cr = new ControlRenovarSuscripcion();

    //int idCliente = Integer.parseInt(thisRequest.getParameter("idCliente").trim());
    out.println("<p>La suscripcion del cliente: " + idAutor +  " .</p>");

    cr.renovarSuscripcion(idAutor);

    out.println("<p>La suscripcion del cliente: " + idAutor +  " fue renovada.</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");
  }

}

