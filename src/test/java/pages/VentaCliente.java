package pages;

import conexion.DriversContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.ReportAllure.addStep;
import static utils.MetodosUtils.*;

public class VentaCliente {
    private AppiumDriver driver;

    public VentaCliente(){
        this.driver = DriversContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /*** Objetos*/
    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement botonEliminaCliente;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement botonOk;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement botonAgregaVenta;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vercli_ultVenta")
    private MobileElement ventasRegistradas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement Borrar;

    public void borrarCliente(){
        swipeDown();
        if(esperoObjeto(botonEliminaCliente,5)){
            botonEliminaCliente.click();
            esperaImplicita(1);
            addStep("Click en eliminar cliente",false, Status.PASSED,false);
        } else addStep("[Error, al Eliminar Cliente]", true, Status.FAILED, true);
        if(esperoObjeto(Borrar,5)){
            Borrar.sendKeys("BORRAR");
            esperaImplicita(1);
            addStep("Escribir 'BORRAR'",false, Status.PASSED,false);
        } else addStep("[Error, al BORRAR Cliente]", true, Status.FAILED, true);
        if (esperoObjeto(botonOk,5)){
            botonOk.click();
            esperaImplicita(1);
            addStep("Cliente eliminado",false, Status.PASSED,false);
        } else addStep("[Error, al eliminar cliente]", true, Status.FAILED, true);
    }

    public void NuevaVenta(){
        if (esperoObjeto(botonAgregaVenta,5)){
            botonAgregaVenta.click();
            esperaImplicita(1);
            addStep("Click en nueva venta",false, Status.PASSED,false);
        } else addStep("[Error, en nueva venta]", true, Status.FAILED, true);

    }
}
