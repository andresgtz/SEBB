package controles;
import entidades.Articulos;

// Canales - RECIBE: idArticulo
// publica el articulos que recibe

public class ControlPublicarArticulo {
  Articulos articulo;

  public ControlPublicarArticulo() {
    articulo = new Articulos();
  }

  public void publicarArticulo(int idArticulo) {
    articulo.publicarArticulo(idArticulo);
  }
}

