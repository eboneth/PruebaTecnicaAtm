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

public class EliminarUsuarioWebTable {

    WebDriver driver;
    Utilidades utilidades;
    String baseURL = "https://demoqa.com/";
    String actualResult = "";

    @Given("^Navegar por el menu pagina y elegir la opcion (.*) -> (.*)$")
    public void elegirOpcionMenu(String menu, String submenu) {

        utilidades = new Utilidades(driver);
        driver = utilidades.setUp(baseURL,driver,"ToolsQA");

        utilidades.navegarMenu(menu,submenu);
        actualResult = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div")).getText();

        Assert.assertEquals(submenu,actualResult);
    }


    @When("^ingrese debo eliminar el usuario (.*)$")
    public void eliminarUsuarioWebTable(String nombre) throws InterruptedException {

        int buscar = utilidades.recorrerTabla(nombre);

        if(buscar != 0){
            utilidades.opcionesUsuario(buscar,"eliminar");
            Thread.sleep(10000);
        }
    }

    @Then("^validar que se haya eliminado correctamente de la tabla (.*)$")
    public void validarDatoEliminado(String nombre) {
        int result = utilidades.recorrerTabla(nombre);

        if (result == 0){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    @And("^cierra el navegador$")
    public void tearDown(){
        driver.quit();
    }
}
