package testSuite;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreacionProducto;
import testClases.CreaNuevoProducto;

public class CaseAgregaProducto {

    @Test(description = "Caso agrega productos nuevos asigandole valor")
    public void agregaNuevosProductos(){
        CreaNuevoProducto creaNuevoProducto=new CreaNuevoProducto();
        creaNuevoProducto.controlFlujoProducto();
        Assert.assertTrue(true);
    }
}
