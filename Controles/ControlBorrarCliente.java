package controles;
import entidades.*;

public class ControlBorrarCliente {
   Cliente suscriptor;
    
    public ControlBorrarCliente() {
    	suscriptor = new Cliente();
    }
    
    public void eliminarCliente(String e) {
        suscriptor.eliminarCliente(e);
    }
}
