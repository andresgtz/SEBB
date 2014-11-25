package controles;
import entidades.*;


public class ControlRenovarSuscripcion{
   Suscripciones suscripcion;

	public ControlRenovarSuscripcion(){
     suscripcion = new Suscripciones();
   }

   public void renovarSuscripcion(int idSuscripcion){
     suscripcion.renovarSuscripcion(idSuscripcion);
   } 
}
