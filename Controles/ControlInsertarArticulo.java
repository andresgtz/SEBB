package controles;
import entidades.Articulo;

// CANALES - RECIBE: int idArticulo, int idRevista, string nombre, string autor, string fecha, string autor, string clasificacion
// aqui se crea un articulo nuevo

public class ControlInsertarArticulo {
  Articulos articulo;

  public ControlInsertarArticulo() {
    articulo = new Articulos();
  }

  public void InsertarArticulo(int idRevista, String nombre, String contenido, String clasificacion) {
    articulo.insertarArticulo(idRevista, nombre, contenido, clasificacion);
  }
}

