import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class BigTest {

    @Test
    public void loginCase() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://swedbank-us1bteam.rhcloud.com/?email=admin%40admin.lt&password=admin#/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonLogin")));

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.className("buttonLogin"));

        email.clear();
        email.sendKeys("admin@admin.lt");
        password.clear();
        password.sendKeys("admin");
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonRegister")));

        driver.navigate().to("http://swedbank-us1bteam.rhcloud.com/#/register");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn")));

        //Register form inputs
        WebElement name = driver.findElement(By.id("name"));
        WebElement surname = driver.findElement(By.id("surname"));
        WebElement phone = driver.findElement(By.id("tel"));
        WebElement regEmail = driver.findElement(By.id("email"));
        Select bank = new Select(driver.findElement(By.id("bank")));
        WebElement date = driver.findElement(By.id("date"));
        Select time = new Select(driver.findElement(By.id("time")));
        Select subject = new Select(driver.findElement(By.id("subject")));
        WebElement message = driver.findElement(By.id("message"));
        WebElement regButton = driver.findElement(By.className("btn"));

        name.sendKeys("Tester");
        surname.sendKeys("Testauskas");
        phone.sendKeys("+37061855511");
        regEmail.sendKeys("test@demo.net");
        bank.selectByIndex(2);
        date.click();
        driver.findElement(By.linkText("28")).click();
        time.selectByVisibleText("13:00");
        subject.selectByIndex(2);
        message.sendKeys("Labas");
        regButton.click();


        driver.navigate().to("http://swedbank-us1bteam.rhcloud.com/#/history");

        Thread.sleep(2000);


        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-xs-12']/table/tbody/tr[@class='ng-scope']"));
        Assert.assertTrue(elements.get(elements.size()-1).getText().contains("2016-03-28"+'\n'+ "13:00:00"+'\n'+ "Antakalnio g. 45"+'\n'+ "Taupymas ir investavimas"));
    }
}