package utils;

import conexion.DriversContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;




public class MetodosUtils {

    public static boolean esperoObjeto(MobileElement elemento, int tiempoEspera){
        try {
            System.out.println("Esperando elemento: "+elemento+", "+tiempoEspera+" , segundos hasta que se visualice");
            WebDriverWait wait = new WebDriverWait(DriversContext.getDriver(),tiempoEspera);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro el elemento ("+elemento+"), se retorna TRUE");
            return true;
        }catch (Exception e){
            System.out.println("No se encontró el elemento ("+elemento+"), se retorna FALSE");
            return false;
        }
    }

    public  static void swipeDown(){
        int ancho = (int) (DriversContext.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriversContext.getDriver().manage().window().getSize().height * 0.9D);
        int endPoint = (int) (DriversContext.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction( DriversContext.getDriver() );
        touchAction.press( PointOption.point( ancho, startPoint ) ).waitAction( WaitOptions.waitOptions( Duration.ofMillis( 500L ) )).moveTo( PointOption.point( ancho, endPoint ) ).release().perform();
        System.out.println("Swipe hacia abajo");
    }
    public static void esperaImplicita(int segundos) {
        DriversContext.getDriver().manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }
}
