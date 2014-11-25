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

  public String verificarArticulo(int idArticulo) {
    return articulo.verificarArticulo(idArticulo);
  }
}