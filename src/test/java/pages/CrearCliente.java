package pages;

import conexion.DriversContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.ReportAllure.addStep;
import static utils.MetodosUtils.esperoObjeto;

public class CrearCliente {

    private AppiumDriver driver;

    public CrearCliente(){
        this.driver = DriversContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Cliente\")]")
    private MobileElement tituloCrearCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement Nombre;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement IdentificadorCli;
    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement Fono;
    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement Direccion;
    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement Notas;
    @AndroidFindBy(id = "com.rodrigo.registro:id/cambiar_ubicacion")
    private MobileElement BotonSeleccionaUbicacion;
    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement botonGuardar;

    public void validarVistaDesplegada(){
        if(esperoObjeto(tituloCrearCliente, 5)){
            addStep("[Validar titulo de la vista Crear Cliente]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Crear Cliente]", true, Status.FAILED, true);
        }
    }

    public void completarFormularioCrearCliente(String nombre, String id, String fono, String direccion, String notas){
        System.out.println("[ Completar Formulario Para Cliente ]");
        Nombre.setValue( nombre );
        this.driver.hideKeyboard();
        IdentificadorCli.click();
        IdentificadorCli.setValue( id );
        this.driver.hideKeyboard();
        Fono.click();
        Fono.setValue( fono );
        this.driver.hideKeyboard();
        Direccion.click();
        Direccion.setValue( direccion );
        this.driver.hideKeyboard();
        Notas.click();
        Notas.setValue( notas );
        this.driver.hideKeyboard();
        addStep("[Completar formulario De Creaciòn Cliente]", true, Status.PASSED, false);
    }

    public void tapGuardar(){
        botonGuardar.click();
    }

}
