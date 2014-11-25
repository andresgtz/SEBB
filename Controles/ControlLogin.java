package controles;
import entidades.Cliente;

public class ControlLogin {
   Cliente cliente;

   public ControlLogin(){
     cliente = new Cliente(); //Asume que la instancia persiste durante la sesion
   }
   
   //Valida si la cuenta existe en la base de datos
   public Boolean validarCuenta(String email,String password){            
      return cliente.validar(email,password);
   }

   public int getUserId(String email){            
      return(cliente.getUserId(email));
   }

   public int getUserType(String email){            
      return(cliente.getUserType(email));
   }
   
   
}
