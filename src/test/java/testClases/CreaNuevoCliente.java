package testClases;

import io.appium.java_client.AppiumDriver;
import pages.CarruselMobile;
import pages.CrearCliente;
import pages.Registros;

public class CreaNuevoCliente {

    private AppiumDriver driver;

    CarruselMobile carrucelMobile=new CarruselMobile();
    CrearCliente crearCliente= new CrearCliente();
    Registros registros = new Registros();
    /**Asigno valor a las Variables*/
    String nombre= "Rodrigo Espinoza Maltez", id="8970", fono="66426677", direccion="Plaza de la Dignidad S/N", notas="renuncia Piñera";

    public void controlDeFlujo(){
    carrucelMobile.validarVistaDesplegada();
    carrucelMobile.validaTextoVistaOneCarrucel();
    carrucelMobile.recorreCarruselMobile();
    registros.validarVistaDesplegada();
    registros.tapBotonCliente();
    registros.tapBtnCrearCliente();
    crearCliente.validarVistaDesplegada();
    crearCliente.completarFormularioCrearCliente(nombre,id,fono,direccion,notas);
    crearCliente.tapGuardar();
    registros.validarVistaDesplegada();
    registros.buscoNombreCliente(nombre);
    this.driver.hideKeyboard();
    }

}
