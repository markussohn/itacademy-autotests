import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import java.io.File;

public class SampleTest {

    @Test
    public void testCase() {
//        File file = new File("C:/IEDriverServer.exe");
//        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.swedbank.lt/lt/spreadsheets/consumer2");
        WebElement firstInput = driver.findElement(By.id("SpreadsheetRequestedLoanAmount"));
        WebElement secondInput = driver.findElement(By.id("SpreadsheetNetMonthlyIncome"));
        WebElement firstRadio = driver.findElement(By.id("SpreadsheetWageAccount1"));
        WebElement secondRadio = driver.findElement(By.id("SpreadsheetHasOutstandingLoan1"));
        firstInput.clear();
        firstInput.sendKeys("500");
        secondInput.clear();
        secondInput.sendKeys("125");
        firstRadio.click();
        secondRadio.click();
        secondRadio.submit();
        WebElement ActualSum = driver.findElement(By.xpath("//div[contains(@class, 'consumerResultValue')]"));
        Assert.assertEquals(ActualSum.getText(), "14,48 Eur");
        driver.quit();
    }
}