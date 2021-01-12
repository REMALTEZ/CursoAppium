package pages;

import conexion.DriversContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static report.ReportAllure.addStep;
import static utils.MetodosUtils.esperaImplicita;
import static utils.MetodosUtils.esperoObjeto;

public class Registros {

    private AppiumDriver driver;
    public Registros(){
        this.driver = DriversContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /*** Objetos*/


    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloRegistro;
    @AndroidFindBy(xpath = "//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement  botonProductos;
    @AndroidFindBy(xpath = "//*[contains(@text,\"CLIENTES\")]")
    private MobileElement  botonClientes;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement botonExpandir;
    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement botonCreaCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement botonCreaProducto;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private MobileElement nombreCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement nombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> listadoNombreClientes;
    @AndroidFindBy (id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> listadoNombreProductos;
    @AndroidFindBy (id = "com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> preciosProductos;
    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloCliente;

    /**Valido los Clientes */
    public void buscoNombreCliente( String nombre){
        boolean cliente = esperoObjeto( nombreCliente, 4 );
        if(cliente){
            System.out.println("[Valido creacion de cliente: "+nombre+" en vista Registro]");
            addStep("[Cliente creado de forma correcta]", true, Status.PASSED, false);
        }else {
            addStep("[Error, el cliente: "+nombre+" no se encuentra Registro Cliente]", true, Status.FAILED, true);
        }
    }
    public void validarClientes(){
        if(nombreCliente.getText().isEmpty()){
            addStep( "[Error, no existen Clientes ]", true, Status.FAILED, true );
        }else{
            System.out.println("[Se Visualizan Clientes registrados]");
            addStep( "[Se Visualizan Clientes registrados ]", true, Status.PASSED, false );
        }
    }
    public void seleccionarCliente()  {
        System.out.println("[Vista Seleccion Cliente]");
        esperoObjeto( tituloRegistro, 2 );
        int numero = (int) (Math.random() * listadoNombreClientes.size()) + 0;
        System.out.println("\t[Seleccionar cliente al azar, existen "+listadoNombreClientes.size()+" Listado clientes]");
        listadoNombreClientes.get( numero ).click();
        System.out.println("\t[Listado cliente seleccionados: "+tituloCliente.getText()+"]");
    }

    /**Valido los Productos */
    public void buscarNombreProducto( String nombre){
        boolean producto = esperoObjeto( nombreProducto, 4 );
        if(producto){
            System.out.println("[Valido creacion de producto: "+nombre+" en vista Registro]");
            addStep("[Producto creado Creado Correctamente]", true, Status.PASSED, false);
        }else {
            addStep("[Error, el producto: "+nombre+" no se encuentra Registro]", true, Status.FAILED, true);
        }
    }
    public void validarProductos(){
        botonProductos.click();
        if(nombreProducto.getText().isEmpty()){
            addStep( "[Error, no existen Productos ]", true, Status.FAILED, true );
        }else{
            System.out.println("[Existen Productos registrados]");
            addStep( "[Existen Productos registrados ]", true, Status.PASSED, false );
        }
    }
    public void CreaProducto(){
        if (esperoObjeto(botonExpandir,5)){
            botonExpandir.click();
            esperaImplicita(1);
            addStep("Click en boton expandir (+)",true, Status.PASSED,false);
        }
        else addStep("[Error, el cliente: "+botonExpandir+" no se encuentra Registros de Productos]", true, Status.FAILED, true);
        if (esperoObjeto(botonCreaProducto,5)){
            botonCreaProducto.click();
            esperaImplicita(1);
            addStep("Click en crear producto",true, Status.PASSED,false);
        }
        else addStep("[Error, el cliente: "+botonExpandir+" no se encuentra Registros de Productos]", true, Status.FAILED, true);
    }

    /**Valido los Tap y Vista Desplegada */
    public void validarVistaDesplegada(){
        if(esperoObjeto(tituloRegistro, 5)){
            addStep("[Valido titulo de Registro]", true, Status.PASSED, false);
        }else {
            addStep("[Error, al validar titulo Registro]", true, Status.FAILED, true);
        }
    }
    public void tapBotonCreaProducto(){
        if(esperoObjeto( botonCreaProducto, 3 )){
            addStep( "[Tap al boton "+botonCreaProducto+" ]", true, Status.PASSED, false );
            botonCreaProducto.click();
        }else{
            addStep( "[Error, el boton: "+botonCreaProducto+" no se encuentra. ]", true, Status.FAILED, true );
        }
    }
    public void tapBotonCliente(){
        if(esperoObjeto( botonClientes, 3 )){
            addStep( "[Tap al boton "+botonClientes+" ]", true, Status.PASSED, false );
            botonClientes.click();
        }else{
            addStep( "[Error, el boton: "+botonClientes+" no se visualiza. ]", true, Status.FAILED, true );
        }
    }
    public void tapBtnCrearCliente(){
        if(esperoObjeto( botonCreaCliente, 3 )){
            addStep( "[Tap al boton "+botonCreaCliente+" ]", true, Status.PASSED, false );
            botonCreaCliente.click();
        }else{
            addStep( "[Error, el boton: "+botonCreaCliente+" no se visualiza. ]", true, Status.FAILED, true );
        }
    }
}
