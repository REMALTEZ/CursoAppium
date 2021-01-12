package testSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ejemploTestNG {

    private static SoftAssert softAssert= new SoftAssert();

    @BeforeSuite
    public void metodo1(){
        softAssert.fail("Fail SOFT");
        System.out.println("inicio de suite");
    }
    @AfterSuite
    public void metodo2(){
        System.out.println("inicio de suite");
    }

    @Test(priority = 1)
    public void metodo3(){
        System.out.println("Test 1");
        softAssert.fail("Fail SOFT");
        System.out.println("Test 1");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void metodo4(){
        System.out.println("Test 2");
        Assert.assertTrue(true);
        Assert.fail("FAIL");
        System.out.println("Test 2");
    }
    @AfterMethod
    public void metodo5(){
        System.out.println("Termino de Test");
        Assert.assertTrue(true);
    }
}
