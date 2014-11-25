package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlPublicarRevista;

public class InterfazPublicarRevista extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlPublicarRevista cr;

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
    out.println("<h3>Publicar</h3>");

    String operacion = request.getParameter("operacion");
    if(operacion == null){
      pedirDatos();
    } else if(operacion.equals("publicarRevista")){
      publicarRevista();
    }

  }

  public void pedirDatos(){
    out.println("<p>Indique los datos del articulo</p>");
    out.println("<form method=\"GET\" action=\"PublicarRevista\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"publicarRevista\"/>");
    out.println("<p> ID del Revista  <input type=\"text\" name=\"idRevista\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Publicar\"name=\"B1\"></p>");
    out.println("</form>");

    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");
  }

  public void publicarRevista() {
    cr = new ControlPublicarRevista();

    int idRevista = Integer.parseInt(thisRequest.getParameter("idRevista").trim());

    cr.publicarRevista(idRevista);

    out.println("<p>El la Revista " + idRevista +  " fue publicada.</p>");
    out.println("<p>Presione el boton para terminar.</p>");
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" class=\"btn btn-default\" value=\"Terminar\"name=\"B1\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");
  }

}

