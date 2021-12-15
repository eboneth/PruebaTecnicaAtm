package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.ID, using = "alertButton")
    private WebElement btnClickMe1;

    @FindBy(how = How.ID, using = "timerAlertButton")
    private WebElement btnClickMe2;

    @FindBy(how = How.ID,using = "confirmButton")
    private WebElement btnClickMe3;

    @FindBy(how = How.ID, using = "promtButton")
    private WebElement btnClickMe4;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
    }

    public void clicBotonAlert(){
        btnClickMe1.click();
    }

    public void clicBotonTimerAlert(){
        btnClickMe2.click();
    }

    public void cliBotonConfirm(){
        btnClickMe3.click();
    }

    public void clicBotonPrompt(){
        btnClickMe4.click();
    }

    public String clicBotonAlerts() throws InterruptedException {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        Thread.sleep(3000);

        alert.accept();

        return text;

    }

    public String clicConfirm() throws InterruptedException {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();

        Thread.sleep(3000);

        alert.accept();

        return text;

    }

    public String clicPrompt(String texto) throws InterruptedException {

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.sendKeys(texto);

        Thread.sleep(3000);

        alert.accept();

        return text;
    }
}
