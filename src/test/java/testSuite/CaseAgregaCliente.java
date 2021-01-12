package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import testClases.CreaNuevoCliente;

public class CaseAgregaCliente {
    @Test(description = "Agrego nuevo Cliente")
    public void agregaNuevoCliente(){
        CreaNuevoCliente creaNuevoCliente=new CreaNuevoCliente();
        creaNuevoCliente.controlDeFlujo();
        Assert.assertTrue(true);
    }
}
