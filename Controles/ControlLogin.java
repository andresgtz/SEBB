package controles;
import entidades.Cliente;

public class ControlLogin {
   Cliente cliente;

   public void ControlLogin(){
     cliente = new Cliente(); //Asume que la instancia persiste durante la sesion
   }
   
   //Valida si la cuenta existe en la base de datos
   public boolean validarCuenta(String email,String password){            
      return(cliente.validar(email,password));
   }
   
   
}
