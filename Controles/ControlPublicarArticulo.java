package controles;
import entidades.*;

// Canales - RECIBE: idArticulo
// publica el articulos que recibe

public class ControlPublicarArticulo {
  Articulos articulo;

  public ControlPublicarArticulo() {
    articulo = new Articulo();
  }

  public void publicarArticulo(int idArticulo) {
    articulo.publicarArticulo(idArticulo, fecha);
  }
}

