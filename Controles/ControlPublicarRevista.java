package controles;
import entidades.*;

// Canales - RECIBE: idRevista
// publica el articulos que recibe

public class ControlPublicarRevista {
  Revistas revista;

  public ControlPublicarRevista() {
    revista = new Revista();
  }

  public void publicarArticulo(int idRevista) {
    revista.publicarRevista(idRevista);
  }
}

