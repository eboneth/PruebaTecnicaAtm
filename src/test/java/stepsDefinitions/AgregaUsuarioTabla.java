package stepsDefinitions;

import Utilities.Utilidades;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.AgregarUsuarioPage;

import java.util.concurrent.TimeUnit;


public class AgregaUsuarioTabla {

    String baseURL = "https://demoqa.com/";
    WebDriver driver;
    Utilidades utilidades;
    AgregarUsuarioPage addUser;
    String actualResult = "";

    @Given("^Navegue por el menu pagina y elegir la opcion (.*) -> (.*)$")
    public void ElegirOpcionWebTable(String menu, String submenu){

        utilidades = new Utilidades(driver);
        driver = utilidades.setUp(baseURL,driver,"ToolsQA");

        utilidades.navegarMenu(menu,submenu);
        actualResult = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div")).getText();

        Assert.assertEquals(submenu,actualResult);
    }


    @When("^ingrese debo agregar un nuevo usuario con los datos (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void agregarDatosUsuario(String nombre, String apellido, String email, String edad, String salario, String departamento) throws InterruptedException {

        addUser = new AgregarUsuarioPage(driver);
        addUser.clicAdd();
        addUser.llenarFormulario(nombre,apellido,email,edad,salario,departamento);

        Thread.sleep(10000);

    }

    @Then("^validar que se visualice en la tabla el usuario (.*)$")
    public void validarRegistro(String nombre) {

        int result = utilidades.recorrerTabla(nombre);

        if(result != 0){
            System.out.println("El usuario se guardó correctamente");
            Assert.assertTrue(true);
        }else{
            System.out.println("El usuario no se almacenó correctamente");
            Assert.assertTrue(false);
        }

    }

    @And("^cerrar el navegador$")
    public void tearDown(){
        driver.quit();
    }

}
