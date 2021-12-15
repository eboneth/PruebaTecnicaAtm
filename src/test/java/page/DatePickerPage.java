package page;

import Utilities.Utilidades;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DatePickerPage {

    WebDriver driver;
    Utilidades utilidades;

    @FindBy(how = How.XPATH, using = "//*[@id='datePickerMonthYear']/div[1]")
    private WebElement txtSelectDate;

    @FindBy(how = How.XPATH, using = "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select[@class='react-datepicker__month-select']")
    private WebElement slcMes;

    @FindBy(how = How.XPATH, using = "//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select[@class='react-datepicker__year-select']")
    private WebElement slcAnio;

    public DatePickerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utilidades = new Utilidades(driver);
    }

    public void clicSelecDate() {
        txtSelectDate.click();
    }

    public void selectMes(String mes) throws InterruptedException {

        String m = utilidades.mes(mes);
        new Select(slcMes).selectByVisibleText(m);

        Thread.sleep(3000);
    }

    public void selectAnio(String anio) throws InterruptedException {

        new Select(slcAnio).selectByVisibleText(anio);

        Thread.sleep(3000);

    }

    public void elegirFecha(String date) throws InterruptedException {
        String anio = date.split("/")[2];
        String mes = date.split("/")[0];
        String dia = date.split("/")[1];

        selectMes(mes);
        selectAnio(anio);

        utilidades.recorrerCalendario(dia);


    }




}
