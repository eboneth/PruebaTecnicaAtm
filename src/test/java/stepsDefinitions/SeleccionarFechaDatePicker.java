package stepsDefinitions;

import Utilities.Utilidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.DatePickerPage;

public class SeleccionarFechaDatePicker {

    WebDriver driver;
    Utilidades utilidades;
    String baseURL = "https://demoqa.com/";
    String actualResult= "";
    DatePickerPage datePicker;

    @Given("^ingresar a la pagina y navegar a la opcion (.*), (.*)$")
    public void setUp(String menu, String submenu){
        System.out.println("ingreso a la pagina y navegó");
        utilidades = new Utilidades(driver);
        driver = utilidades.setUp(baseURL,driver,"ToolsQA");

        utilidades.navegarMenu(menu, submenu);
        actualResult = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div")).getText();

        Assert.assertEquals(submenu,actualResult);

    }

    @When("^cuando ingrese debo agregar fechas validas a los campos (.*)$")
    public void ingresarFechas(String selectDay) throws InterruptedException {

        datePicker = new DatePickerPage(driver);

        datePicker.clicSelecDate();
        Thread.sleep(1000);

        datePicker.elegirFecha(selectDay);

    }
    @Then("^debo poder cerrar el navegador$")
    public void tearDown(){
        driver.quit();
    }
}
