package testClases;
import pages.CarruselMobile;

/**EJEMPLO REALIZADO EN CLASES */
public class TestCarrucel {

    CarruselMobile carrucelMobile=new CarruselMobile();
    public void validaciones(){
      carrucelMobile.validarVistaDesplegada();
      carrucelMobile.validaTextoVistaOneCarrucel();
      carrucelMobile.recorreCarruselMobile();
    }
}
