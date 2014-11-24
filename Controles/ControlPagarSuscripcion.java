package controles;
import entidades.Suscripcion;

public class ControlPagarSuscripcion {
  Suscripciones suscripcion;

  public ControlPagarSuscripcion {
    suscripcion = new Suscripcion();
  }

  public void pagarSuscripcion(int idSuscripcion) {
    suscripcion.pagarSuscripcion(idSuscripcion);
  }
}
