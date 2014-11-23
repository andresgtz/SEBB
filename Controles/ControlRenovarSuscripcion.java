package controles;
import entidades.Suscripciones;


public class ControlRenovarSuscripcion {
   Suscripciones suscripcion;

   public ControlRenovarSuscripcion(){
     suscripcion = new Suscripcion();
   }

   public void renovarSuscripcion(int idSuscripcion){
     suscripcion.renovarSuscripcion(idSuscripcion);
   } 
}
