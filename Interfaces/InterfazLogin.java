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
  int userid = -1;
  int usertype = 0;
  
   public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest =request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Pagina Web de respuesta
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
    out.println("<TITLE>Login</TITLE>");
    out.println("<h2>SEBB</h2>");
    //out.println("<h3>Loginr Saldo</h3>");
    out.println("<h3>Log in!</h3>");
    out.println("<p></p>");
    //out.println("<a href=\"menu.html\"> Regresar al menu principal </a>");
     


    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarLogin();  
    }else if(operacion.equals("validar")){
      validarCuenta();
    } 
  }



  public void iniciarLogin(){   
    out.println("<p>Indique el correo de la cuenta y contrase;a </p>");
    out.println("<form method=\"GET\" action=\"Login\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
    out.println("<p> Usuario  <input type=\"text\" name=\"usuario\" size=\"15\"></p>");
    out.println("<p> Constrasena <input type=\"text\" name=\"contrasena\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"index.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");
    out.println("</div>");//c
    out.println("</div>");//c
    out.println("</BODY>");
    out.println("</HTML>");
      
  }
  

  public void validarCuenta(){  
    ce = new ControlLogin();
    //La funcion trim() elimina espacios antes y despues del valor
    
    String usuario = thisRequest.getParameter("usuario").trim();
    String contrasena = thisRequest.getParameter("contrasena").trim();
    boolean existente = ce.validarCuenta(usuario,contrasena);
    if (existente){
      out.println("<p>Los datos son correctos, bienvenido "+usuario+"</p>");
      userid = ce.getUserId(usuario);
      usertype = ce.getUserType(usuario);
      
      out.println("<p>Indique la operacion que desea realizar</p>");

      if (userid < 0) {
        iniciarLogin();
      } else if (usertype == 1) {
        out.println("<p>Menu de autor</p>");
        menuSuscriptor();
        menuAutor();
      } else if (usertype == 0) {
        out.println("<p>Menu de suscriptor</p>");
        menuSuscriptor();
      } else if (usertype == 2) {
        out.println("<p>Menu de juez</p>");
        menuSuscriptor();
        menuJuez();
      } else if (usertype == 3) {
        out.println("<p>Menu de editor en jefe</p>");
        menuSuscriptor();
        menuJuez();
        menuEditorEnJefe();
      }

      out.println("<a href='index.html'>Salir</a>");

      out.println("</form>");
      out.println("</div>");//c
      out.println("</div>");//c
      out.println("</BODY>");
      out.println("</HTML>");
    } else {
      out.println("<p style='color:red;'>Los datos son incorrectos.</p>");
      iniciarLogin();
    }
  }
    
    public void menuAutor() {

      out.println("<form method=\"GET\" action=\"InsertarArticulo\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Crear un articulo\"name=\"B1\"></p>");
      out.println("</form>");

      out.println("<form method=\"GET\" action=\"InsertarRevista\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Crear revista\"name=\"B1\"></p>");
      out.println("</form>");
    }

    public void menuJuez() {

      out.println("<form method=\"GET\" action=\"PublicarArticulo\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Publicar un articulo\"name=\"B1\"></p>");
      out.println("</form>");
    }

    public void menuEditorEnJefe() {
      // out.println("<form method=\"GET\" action=\"SeleccionarJuez\">");                 
      // out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      // out.println("<p><input type=\"submit\" value=\"Seleccionar un juez\"name=\"B1\"></p>");
      // out.println("</form>");

      out.println("<form method=\"GET\" action=\"PublicarArticulo\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Publicar algun articulo\"name=\"B1\"></p>");
      out.println("</form>");
    }

    public void menuSuscriptor() {

      out.println("<form method=\"GET\" action=\"AbrirArticulo\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Abrir a articulo\"name=\"B1\"></p>");
      out.println("</form>");

      out.println("<form method=\"GET\" action=\"AbrirRevista\">");                 
      out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      out.println("<p><input type=\"submit\" value=\"Abrir revista\"name=\"B1\"></p>");
      out.println("</form>");

      // out.println("<form method=\"GET\" action=\"RenovarSuscripcion\">");                 
      // out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      // out.println("<p><input type=\"submit\" value=\"Renovar la suscripcion\"name=\"B1\"></p>");
      // out.println("</form>");

      // out.println("<form method=\"GET\" action=\"SolicitarEdicion\">");                 
      // out.println("<input type=\"hidden\" name=\"idUsuario\" value=\"" + userid + "\"/>");       
      // out.println("<p><input type=\"submit\" value=\"Solicitar una edicion\"name=\"B1\"></p>");
      // out.println("</form>");

    }
  

}
