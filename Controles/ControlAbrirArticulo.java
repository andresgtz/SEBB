package controles;
import entidades.Articulo;

public class ControlInsertarArticulo {
  Articulos articulo;

  public ControlInsertarArticulo() {
    articulo = new Articulo();
  }

  public String AbrirArticulo(int idArticulo) {
    return articulo.abrirArticulo(idArticulo);
  }
}