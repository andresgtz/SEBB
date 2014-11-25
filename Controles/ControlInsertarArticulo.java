package controles;
import entidades.Articulos;

// CANALES - RECIBE: int idArticulo, int idRevista, string nombre, string autor, string fecha, string autor, string clasificacion
// aqui se crea un articulo nuevo

public class ControlInsertarArticulo {
  Articulos articulo;

  public ControlInsertarArticulo() {
    articulo = new Articulos();
  }

  public void InsertarArticulo(int idRevista, int idAutor, String nombre, String contenido, String clasificacion) {
    articulo.insertarArticulo(idRevista, idAutor, nombre, contenido, clasificacion);
  }
}

