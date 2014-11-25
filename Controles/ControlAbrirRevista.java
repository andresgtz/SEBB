package controles;
import entidades.Revistas;

public class ControlAbrirRevista {
  Revistas revista;

  public ControlAbrirRevista() {
    revista = new Revistas();
  }

  public String verArticulos(int idRevista) {
   return revista.verArticulos(idRevista);
  }

}