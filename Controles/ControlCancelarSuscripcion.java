package controles;
import entidades.Suscripciones;

public class ControlCancelarSuscripcion {
  Suscripciones suscripcion;

  public ControlCancelarSuscripcion(){
    suscripcion = new Suscripcion();
  }

  public void cancelarSuscripcion(int idSuscripcion){
    suscripcion.cancelarSuscripcion(idSuscripcion);
  }
}
