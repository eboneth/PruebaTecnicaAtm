package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AgregarUsuarioPage {

    WebDriver driver;

    @FindBy(how = How.ID, using = "addNewRecordButton")
    private WebElement btnAdd;

    @FindBy(how = How.ID, using = "firstName")
    private WebElement txtFirstName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement txtLastName;

    @FindBy(how = How.ID, using = "userEmail")
    private WebElement txtUserEmail;

    @FindBy(how = How.ID, using = "age")
    private WebElement txtAge;

    @FindBy(how = How.ID, using = "salary")
    private WebElement txtSalary;

    @FindBy(how = How.ID, using = "department")
    private WebElement txtDepartment;

    @FindBy(how = How.ID, using = "submit")
    private WebElement btnSubmit;

    public AgregarUsuarioPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clicAdd(){
        btnAdd.click();
    }

    public void setFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        txtLastName.sendKeys(lastName);
    }

    public void setEmail(String email){
        txtUserEmail.sendKeys(email);
    }

    public void setAge(String age){
        txtAge.sendKeys(age);
    }

    public void setSalary(String salary){
        txtSalary.sendKeys(salary);
    }

    public void setDepartment(String department){
        txtDepartment.sendKeys(department);
    }

    public void clicBtnSubmit(){
        btnSubmit.click();
    }

    public void llenarFormulario(String name,String lastname,String email, String age, String salary, String department) throws InterruptedException {

        setFirstName(name);
        setLastName(lastname);
        setEmail(email);
        setAge(age);
        setSalary(salary);
        setDepartment(department);

        clicBtnSubmit();
    }


}
