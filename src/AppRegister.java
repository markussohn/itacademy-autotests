import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by justinas on 16.3.4.
 */
public class AppRegister {

    private final WebDriver driver;


    public AppRegister(WebDriver driver) {
        this.driver = driver;
    }

    public void getPage() {
        driver.get("http://swedbank-us1bteam.rhcloud.com/?email=admin%40admin.lt&password=admin#/");
    }

    public void enterUsername(String username) {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passw = driver.findElement(By.id("password"));
        passw.clear();
        passw.sendKeys(password);
    }

    public void clickButton() {
        WebElement loginButton = driver.findElement(By.className("buttonLogin"));
        loginButton.click();
    }

    public void waitForPage(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className(id)));
    }

    public void waitForRegisterPage() throws InterruptedException {
        Thread.sleep(1500);
    }

    public void getRegisterPage() {
        driver.navigate().to("http://swedbank-us1bteam.rhcloud.com/#/register");
    }

    public void getHistoryPage() {
        driver.navigate().to("http://swedbank-us1bteam.rhcloud.com/#/history");
    }

    public void enterName(String name){
        WebElement firstName = driver.findElement(By.id("name"));
        firstName.clear();
        firstName.sendKeys(name);
    }

    public void enterSurname(String surname){
        WebElement lastName = driver.findElement(By.id("surname"));
        lastName.clear();
        lastName.sendKeys(surname);
    }

    public void enterPhone(String phone){
        WebElement phonenumber = driver.findElement(By.id("tel"));
        phonenumber.clear();
        phonenumber.sendKeys(phone);
    }

    public void enterEmail(String eMail) {
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys(eMail);
    }

    public void selectBank(int id){
        Select bank = new Select(driver.findElement(By.id("bank")));
        bank.selectByIndex(id);
    }

    public void pickDate(String day){
        WebElement date = driver.findElement(By.id("date"));
        date.click();
        driver.findElement(By.linkText(day)).click();
    }

    public void selectTime(String hours){
        Select time = new Select(driver.findElement(By.id("time")));
        time.selectByVisibleText(hours);
    }

    public void selectSubject(int id){
        Select subject = new Select(driver.findElement(By.id("subject")));
        subject.selectByIndex(id);
    }

    public void clickRegisterButton(){
        WebElement regButton = driver.findElement(By.className("btn"));
        regButton.click();
    }

    public void assertConfirmation(String data) {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col-xs-12']/table/tbody/tr[@class='ng-scope']"));
        Assert.assertTrue(elements.get(elements.size()-1).getText().contains(data));
    }

}
