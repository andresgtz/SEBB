package controles;
import entidades.Cliente;

// CANALES - RECIBE: int idArticulo, int idRevista, string nombre, string autor, string fecha, string autor, string clasificacion
// aqui se crea un articulo nuevo

public class ControlInsertarArticulo {
  Cliente cliente;

  public ControlInsertarArticulo() {
    cliente = new Cliente();
  }

  public void InsertarArticulo(int idArticulo, int idRevista, String nombre, String autor, String clasificacion) {
    cliente.insertarArticulo(idArticulo, idRevista, nombre, autor, clasificacion);
  }
}

