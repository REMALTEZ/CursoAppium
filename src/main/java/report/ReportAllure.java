package report;

import conexion.DriversContext;
import conexion.DriversManager;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.omg.CosNaming.IstringHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;



public class ReportAllure {

    private static SoftAssert softAssert= new SoftAssert();

    public static void addStep(String descripcion, boolean screenshoot, Status status, boolean fatal){
        String uuid= UUID.randomUUID().toString();
        StepResult result= new StepResult().setName(descripcion).setStatus(status);
        Allure.getLifecycle().startStep(uuid,result);
        if(screenshoot){
            reportScreenShoot();
        }
        Allure.getLifecycle().stopStep(uuid);
        softAssert.assertTrue(true,descripcion);

        if(status.equals(Status.FAILED)){
            softAssert.fail(descripcion);
        }

        if(fatal){
            Assert.fail(descripcion);
        }

        System.out.println("[Report]  "+descripcion);
    }

    private static void reportScreenShoot(){
        File scrFile;
        scrFile = (File) DriversContext.getDriver().getScreenshotAs(OutputType.FILE);
        //scrFile = (TakesScreenshot) DriversContext.getDriver().getScreenshotAs(OutputType.FILE);
        File foto=new File(scrFile.getPath());
        InputStream image;
        try {
            image= new FileInputStream(foto);
            Allure.addAttachment("Imagen Adjunta",image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void finalAssert(){
        softAssert.assertAll();
    }
}
