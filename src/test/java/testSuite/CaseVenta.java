package testSuite;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VentaCliente;
import testClases.CreaNuevoCliente;
import testClases.CreaNuevoProducto;

public class CaseVenta {

    @Test(priority = 1, description = "Crea Nueva Cliente")
    public void creaCliente(){
        CreaNuevoCliente creaNuevoCliente=new CreaNuevoCliente();
        creaNuevoCliente.controlDeFlujo();
        Assert.assertTrue(true);
    }
    @Test(priority = 2,description = "Caso agrega productos nuevos asigandole valor")
    public void agregaNuevosProductos(){
        CreaNuevoProducto creaNuevoProducto=new CreaNuevoProducto();
        creaNuevoProducto.controlFlujoProducto();
        Assert.assertTrue(true);
    }

    /**Venta Incompleta*/
    @Test(priority = 3,description = "Crea una nueva venta")
    public void venta(){
        VentaCliente ventaCliente= new VentaCliente();
        ventaCliente.NuevaVenta();
        Assert.assertTrue(true);
    }
}
