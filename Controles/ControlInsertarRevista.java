package controles;
import entidades.Revistas;

// CANALES - RECIBE: int idRevista, string titulo, int numeroVolumen, string issn, string fecha
// aqui se crea una revista nueva

public class ControlInsertarRevista {
  Revistas revista;

  public ControlInsertarRevista() {
    revista = new Revistas();
  }

  public void InsertarRevista(String titulo, int numeroVolumen, String ISSN ,String fechaPublicacion) {
    revista.insertarRevista(titulo,numeroVolumen,ISSN,fechaPublicacion);
  }
}
}

