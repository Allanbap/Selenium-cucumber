package Steps;

import Base.BaseUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginStep  {


    private WebDriver driver = null;





    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {

        /*Abrir o Firefox*/
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Allan\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.get("https://demosite.executeautomation.com/Login.html");



    }

    @And("I enter the username:admin and password:pass")
    public void iEnterTheUsernameAdminAndPasswordPass() throws InterruptedException {
        /*Mandar para o bot escrever*/
        WebElement campoName = driver.findElement(By.name("UserName"));
        campoName.sendKeys("Admin");
        WebElement campoPass = driver.findElement(By.name("Password"));
        campoPass.sendKeys("pass");

        /*Pegar as palavaras no site*/
        campoName.click();
        String username = campoName.getAttribute("value");
        campoPass.click();
        String pass = campoPass.getAttribute("value");

        /*Comparação com os campos*/
        Assert.assertEquals( "Admin", username);
        Assert.assertEquals( "pass", pass);
    }



    @And("I click login  button")
    public void iClickLoginButton() {
        driver.findElement(By.name("Login")).submit();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
    }



}
