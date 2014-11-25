package controles;
import entidades.Articulos;

public class ControlAbrirArticulo {
  Articulos articulo;

  public ControlAbrirArticulo() {
    articulo = new Articulos();
  }

  public String AbrirArticulo(int idArticulo) {
    return articulo.getArticulo(idArticulo);
  }
}