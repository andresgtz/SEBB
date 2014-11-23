package controles;
import entidades.*;

public class ControlRegistro {
    Cliente suscriptor = new Cliente();
    
    public void ControlRegistro() {
    }
    
    public void agregarCliente(String email, String nombre, String apellido, String telefono, String password) {
        suscriptor.agregarCliente(email, nombre, apellido, telefono, password);
    }
}