/*
  `Jesus Navarro A00813111
   Andrés Gutiérrez A01191581



*/


// EJERCICIO: Elaborar una aplicacion que utilice el patron Adapter

// Existe una clase Temperatura que opera con temperaturas en grados Celsius, con
// metodos para getTemperatura y setTemperatura.

// La nueva clase Temperature opera con temperaturas en grados Fahrenheit, con
// metodos setTemperature y getTempreature.

// El cliente siempre espera guardar y recibir temperaturas en grados Celsius.

// El adaptador debera convertir las temperaturas de Celsius a Fahernheit y viceversa
// implementando los metodos getTemperatura y setTemperatura.
  
// Probar la clase cliente con acceso a Temperatura y Temperature (esta ultima
// mediante un adatador), para validar que las implementaciones y conversiones son correctas.


// celsius
interface CelsiusInterface { //This is the old interface
  public void setTemp(double n);
  public double getTemp();
}

class CelsiusClass implements CelsiusInterface  {
  double t;
  public void setTemp(double n) {
    t = n;
  }
  public double getTemp() {
    return t;
  }
}

//farenheit
interface FarenheitInterface { //This is the new interface to be adapted
  public void setTemp(double f);
  public double getTemp();
}


class FarenheitClass implements FarenheitInterface {
  double t;
  public void setTemp(double f){
  	t=f;
  }
  public double getTemp(){
  	return t;
  }
}


//conversion c -> far
class CelsiusToFarenheit implements CelsiusInterface {
  FarenheitClass farenheitObject;

  CelsiusToFarenheit(){
    farenheitObject = new FarenheitClass();
  }
  
  //celsius -> farenheit
  public void setTemp(double n) {
    //converts celsius to farneheit and saves in farenheitObject
    double f;
    f=(n*1.8) +32;
   	farenheitObject.setTemp(f);
  }
  public double getTemp() {
    return (farenheitObject.getTemp()-32)/1.8;
  }
}

/*
//main celsius
public class AppAdapter { //This is the original client
  public static void main(String args[]) {
    //The client access an AceObject
    CelsiusClass celsiusObject = new CelsiusClass(); 
    celsiusObject.setTemp(29);
    System.out.println("Celsius temp " + celsiusObject.getTemp());
  }
}
*/


//main
public class AppAdapter { //This is the modified client
  public static void main(String args[]) {
    //The client belives it will be accesing an AceObject
    CelsiusToFarenheit celsiusObject = new CelsiusToFarenheit(); 
    celsiusObject.setTemp(29);
    System.out.println("Celsius temp " + celsiusObject.getTemp());
  
}
