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

public class CreacionProducto {
    private AppiumDriver driver;

    public CreacionProducto(){
        this.driver = DriversContext.getDriver();
        PageFactory.initElements( new AppiumFieldDecorator( driver ), this );
    }

/* Objetos*/

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Más opciones\"]")
    private MobileElement optiones;
    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloCrearProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement NombreProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement Precios;
    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement botonConfirmar;

    public void validarVistaDesplegada(){
        if(esperoObjeto(tituloCrearProducto, 5)){
            addStep("[Validar titulo de la vista Crear Producto]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo de la vista Crear Producto]", true, Status.FAILED, true);
        }

    }

    public void CreaFormularioProducto(String nombreProducto, int precio){
        System.out.println("[ Completar formulario Crear Producto ]");
        NombreProducto.click();
        NombreProducto.setValue( nombreProducto );
        this.driver.hideKeyboard();
        Precios.click();
        Precios.setValue( String.valueOf( precio ) );
        this.driver.hideKeyboard();
        addStep("[Completar formulario Crear Producto]", true, Status.PASSED, false);
    }

    public void tapConfirmar(){
        botonConfirmar.click();
    }


}
