package testClases;

import io.appium.java_client.AppiumDriver;
import pages.CarruselMobile;
import pages.CreacionProducto;
import pages.Registros;

public class CreaNuevoProducto {

    private AppiumDriver driver;
    CarruselMobile carruselMobile = new CarruselMobile();
    Registros registros = new Registros();
    CreacionProducto creacionProducto = new CreacionProducto();

    String nombreProducto = "Cerveza Artesanal";
    int precio = 3600;

    public void controlFlujoProducto(){
    carruselMobile.validarVistaDesplegada();
    carruselMobile.validaTextoVistaOneCarrucel();
    carruselMobile.recorreCarruselMobile();
    registros.validarVistaDesplegada();
    registros.CreaProducto();
    creacionProducto.validarVistaDesplegada();
    creacionProducto.CreaFormularioProducto(nombreProducto,precio);
    creacionProducto.tapConfirmar();
    registros.tapBotonCreaProducto();
    registros.buscarNombreProducto(nombreProducto);
    this.driver.hideKeyboard();

    }
}


