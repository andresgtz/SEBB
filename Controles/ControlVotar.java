package controles;
import entidades.*;

public class ControlVotar {
  Articulos articulo;

  public ControlVotar() {
    articulo = new Articulos();
  }

  public void votar(int idArticulo) {
    articulo.votar(idArticulo);
  }
}
