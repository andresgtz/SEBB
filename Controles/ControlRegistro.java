package controles;
import entidades.*;

public class ControlRegistro {
   Cliente suscriptor;
    
    public ControlRegistro() {
    	suscriptor = new Cliente();
    }
    
    public void agregarCliente(String email, String nombre, String apellido, String telefono, String password, int tipo, int tipoCreador) {
        suscriptor.agregarCliente(email, nombre, apellido, telefono, password, int tipo, int tipoCreador);

    }
}
