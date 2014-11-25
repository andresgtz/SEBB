package controles;
import entidades.Articulo;

// CANALES - RECIBE: int idArticulo, int idRevista, string nombre, string autor, string fecha, string autor, string clasificacion
// aqui se crea un articulo nuevo

public class ControlInsertarArticulo {
  Cliente cliente;

  public ControlInsertarArticulo() {
    articulo = new Articulo();
  }

  public void InsertarArticulo(int idArticulo, String fecha, String nombre, String contenido, String clasificacion) {
    cliente.publicarArticulo(idArticulo, fecha, nombre, contenido, clasificacion);
  }
}

