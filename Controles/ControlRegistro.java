package controles;
import entidades.*;

public class ControlRegistro {
   Cliente suscriptor;
    
    public ControlRegistro() {
    	suscriptor = new Cliente();
    }
    
    public void agregarCliente(String usuario, String nombre, String apellido, String telefono, String password, int tipo) {
        suscriptor.agregarCliente(usuario, nombre, apellido, telefono, password, tipo);
    }
}
