package conexion;

import io.appium.java_client.AppiumDriver;

public class DriversContext {

    private static DriversManager driversManager=new DriversManager();

    public static void setUP(String dispositivo, String SO, String aplicacion, String udid, Boolean emulador){
        driversManager.iniciarSesion(dispositivo,SO,aplicacion,udid,emulador);
    }

    public static AppiumDriver getDriver(){
        return driversManager.getDriver();
    }

    public static void quitDriver(){
        driversManager.getDriver().quit();
    }
}
