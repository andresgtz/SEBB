package controles;
import entidades.Suscripciones;

public class ControlCancelarSuscripcion {
  Suscripciones suscripcion;

  public ControlRenovarSuscripcion(){
    suscripcion = new Suscripcion();
  }

  public void cancelarSuscripcion(int idSuscripcion){
    suscripcion.cancelarSuscripcion(idSuscripcion);
  }
}
