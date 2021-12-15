package Utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utilidades {

    WebDriver driver;
    String chromePath = System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
    String actualResult = "";
    String expectedResult = "";
    JavascriptExecutor js;

    public Utilidades(WebDriver driver){

        this.driver = driver;

    }

    public WebDriver setUp(String baseUrl, WebDriver driver, String ex){

        System.setProperty("webdriver.chrome.driver", chromePath);
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.get(baseUrl);

        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        actualResult = this.driver.getTitle();
        expectedResult = ex;

        Assert.assertEquals(actualResult, expectedResult);

        return this.driver;
    }

    public void navegarMenu(String menu, String submenu){

        int indexMenu = 0;
        int indexSubmenu = 0;
        JavascriptExecutor js = (JavascriptExecutor)driver;

        //Elegir opcion menu
        WebElement listMenu = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div"));
        List<WebElement> listaMenu = listMenu.findElements(By.tagName("h5"));

        for (int i = 0 ; i<listaMenu.size(); i++){
            if(listaMenu.get(i).getText().contains(menu)){
                indexMenu = i + 1;
                break;
            }
        }

        WebElement opcMenu = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div/div["+indexMenu+"]"));
        opcMenu.click();

        //Elegir submenu
        WebElement listSubmenu = driver.findElement(By.xpath("*//div[@class='left-pannel']/div[@class='accordion']/div["+indexMenu+"]/div/ul"));
        List<WebElement> listaSubmenu = listSubmenu.findElements(By.tagName("span"));

        for(int j = 0; j<listaSubmenu.size();j++){
            if(listaSubmenu.get(j).getText().contains(submenu)){
                indexSubmenu = j+1;
                break;
            }
        }
        WebElement opcSubmenu = driver.findElement(By.xpath("*//div[@class='left-pannel']/div[@class='accordion']/div["+indexMenu+"]/div/ul/li[@id='item-"+indexSubmenu+"']/span"));
        js.executeScript("arguments[0].scrollIntoView();", opcSubmenu);
        opcSubmenu.click();
        js.executeScript("window.scrollBy(0,-1000)");
    }

    public int recorrerTabla(String search) {

        int indexFila = 0;

        WebElement baseTable = driver.findElement(By.xpath("*//div[@class='rt-tbody']"));
        List<WebElement> tableRows = baseTable.findElements(By.className("rt-tr-group"));

        for (int i = 0; i < tableRows.size(); i++) {
            if(tableRows.get(i).getText().contains(search)){
                indexFila = i+1;
                break;
            }
        }
        return indexFila;
    }

    public void opcionesUsuario(int index, String opcion){
        if(opcion.equals("eliminar")){
            WebElement clicEliminar = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div["+index+"]/div/div[7]/div/span[@id='delete-record-"+index+"']"));
            clicEliminar.click();
        }else if(opcion.equals("editar")){
            WebElement clicEditar = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/div["+index+"]/div/div[7]/div/span[@id='edit-record-"+index+"']"));
            clicEditar.click();
        }
    }

    public String mes(String mes){

        String m = "";

        switch (mes){
            case "01":
                return "January";
            case "02":
                return "February";
            case "03":
                return "March";
            case "04":
                return "April";
            case "05":
               return "May";
            case "06":
                return "June";
            case "07":
                return "July";
            case "08":
                return "August";
            case "09":
                return "September";
            case "10":
                return "October";
            case "11":
                return "November";
            case "12":
                return "December";
            default:
                System.out.println("mes incorrecto");
        }

        return m;
    }

    public void recorrerCalendario(String dia) throws InterruptedException {

        int d = Integer.parseInt(dia);
        System.out.println("el dia a elegir es: "+d);

        int indFila = 0;
        int indexColumna = 0;

        WebElement baseTable = driver.findElement(By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]"));
        List<WebElement> dias = baseTable.findElements(By.className("react-datepicker__week"));

        for (int i = 0; i < dias.size(); i++) {
            if(dias.get(i).getText().contains(dia)){
                if(d>=25 && d<=31 && i==0){

                }else{
                    indFila = i+1;
                    break;
                }
            }
        }

        WebElement filaDias = driver.findElement(By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]/div["+indFila+"]"));
        List<WebElement> fDias = filaDias.findElements(By.tagName("div"));

        for(int j = 0; j < fDias.size(); j++){

            if(fDias.get(j).getText().contains(dia)){
                indexColumna = j+1;
                break;
            }
        }

        WebElement numberDay = driver.findElement(By.xpath("//*[@id='datePickerMonthYear']/div[2]/div[2]/div/div/div[2]/div[2]/div["+indFila+"]/div["+indexColumna+"]"));
        numberDay.click();

        Thread.sleep(7000);

    }
}
