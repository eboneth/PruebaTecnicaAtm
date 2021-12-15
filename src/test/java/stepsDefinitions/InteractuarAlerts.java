package stepsDefinitions;

import Utilities.Utilidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import page.AgregarUsuarioPage;
import page.AlertsPage;

public class InteractuarAlerts {

    String baseURL = "https://demoqa.com/";
    WebDriver driver;
    Utilidades utilidades;
    AlertsPage alert;
    String actualResult = "";
    String textBtnUno = "";
    String textBtnDos = "";
    String textBtnTres = "";
    String textResult = "";
    String textBtnCuatro = "";
    String textResultPrompt = "";


    @Given("^abrir el navegardor e ingresar al portal y elegir las opciones (.*), (.*)$")
    public void setUp(String menu, String submenu) {

        utilidades = new Utilidades(driver);
        driver = utilidades.setUp(baseURL,driver,"ToolsQA");

        utilidades.navegarMenu(menu,submenu);
        actualResult = driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/div")).getText();

        Assert.assertEquals(submenu,actualResult);

    }


    @When("^interactuar con las opciones de las alertas (.*)$")
    public void interactuarAlertas(String texto) throws InterruptedException {

        try{
            alert = new AlertsPage(driver);

            alert.clicBotonAlert();
            textBtnUno = alert.clicBotonAlerts();

            alert.clicBotonTimerAlert();
            textBtnDos = alert.clicBotonAlerts();

            alert.cliBotonConfirm();
            textBtnTres = alert.clicConfirm();
            textResult = driver.findElement(By.xpath("//*[@id='confirmResult']")).getText();

            alert.clicBotonPrompt();
            textBtnCuatro = alert.clicPrompt(texto);
            textResultPrompt = driver.findElement(By.xpath("//*[@id='promptResult']")).getText();

        }catch (NoAlertPresentException al){
            System.out.println(al.getMessage());
        }

    }

    @Then("^validar el resultado de las alertas$")
    public void validar_el_resultado_de_las_alertas() {

        boolean result = textBtnUno.contains("You clicked a button") && textBtnDos.contains("This alert appeared after 5 seconds")
                    && textBtnTres.contains("Do you confirm action?") && textResult.contains("You selected") && textBtnCuatro.contains("Please enter your name")
                    && textResultPrompt.contains("You entered");

        if (result){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

        driver.quit();

    }

}
