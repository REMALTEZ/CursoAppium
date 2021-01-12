package pages;

import conexion.DriversContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static report.ReportAllure.addStep;
import static utils.MetodosUtils.esperoObjeto;
import static utils.MetodosUtils.*;

public class CarruselMobile {

    // public Object validarVistaDesplegada;
    private AppiumDriver driver;

    public CarruselMobile(){
        this.driver = DriversContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    /* Reconocimiento de Objetos */
    @AndroidBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVistaOne;
    @AndroidBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;
    @AndroidBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;
    @AndroidBy(id = "com.rodrigo.registro:id/next")
    private MobileElement botonFlecha;
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement botonPermitir;
    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement botonHecho;

    /**  Metodos  */
    public void validarVistaDesplegada(){
        if (iconoVistaOne.isDisplayed()){
            addStep("Validar Vista 1 de carrucel",false, Status.PASSED,false);
        }else{
            addStep("Validar Vista 1 de carrucel",true, Status.FAILED,true);
        }
    }

    public void validaTextoVistaOneCarrucel(){
        String textoDescriptivo= descripcionVista.getText();
        if(textoDescriptivo.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")){
            addStep("Validar Vista 1 de carrucel- Descripcion",true, Status.PASSED,false);
        }else{
            addStep("Validar Vista 1 de carrucel",true, Status.FAILED,true);
        }
    }

   /** opcion 1 recorreCarrucelMobile
    public void recorreCarruselMobile(){
        System.out.println("[Vista Carrusel] ");
        for (int clickBtn = 1; clickBtn < 4; clickBtn++){
            System.out.println("\t[realizo un TAB [ " +clickBtn+" para boton flecha]");
            botonFlecha.click();
        }
    }
    */

    public void recorreCarruselMobile(){
        for (int clickBtn = 1;  clickBtn < 4;  clickBtn ++){
            if (esperoObjeto(botonFlecha,5)){
                botonFlecha.click();
                esperaImplicita(2);
                addStep(String.format("Recorriendo Carrusel vista 1.%s", clickBtn),true,Status.PASSED,false);
            }
            else {
                addStep(String.format("Recorriendo Carrusel vista 1.%s", clickBtn),true,Status.FAILED,false);
            }
        }
        if (esperoObjeto(botonPermitir,5)){
            botonPermitir.click();
            esperaImplicita(2);
            addStep("Permisos de escritura concedidos",true,Status.PASSED,false);
        }
        if (esperoObjeto(botonHecho,5)){
            botonHecho.click();
            esperaImplicita(2);
            addStep("Recorrido de carrusel terminado",true,Status.PASSED,false);
        }
        else {
            addStep("Recorrido de carrusel terminado",true,Status.FAILED,false);
        }


    }



}
