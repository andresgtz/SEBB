package controles;
import entidades.Articulo;

public class ControlPublicarArticulo {
  Articulos articulo;

  public ControlPublicarArticulo() {
    articulo = new Articulo();
  }

  public void publicarArticulo(int idArticulo, String fecha) {
    articulo.publicarArticulo(idArticulo, fecha);
  }
}

