import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by justinas on 16.3.4.
 */
public class AppRegisterTest {

    private final static WebDriver driver = new FirefoxDriver();
    private final static AppRegister login = new AppRegister(driver);

    @Before
    public void setUp() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void loginAndRegister() throws InterruptedException {

        login.getPage();
        login.enterUsername("admin@admin.lt");
        login.enterPassword("admin");

        login.clickButton();

        login.waitForPage("buttonRegister");
        login.getRegisterPage();
        login.waitForRegisterPage();
        login.enterName("Tester");
        login.enterSurname("Testauskas");
        login.enterPhone("+37061855522");
        login.enterEmail("tester@demo.net");
        login.selectBank(2);
        login.pickDate("28");
        login.selectTime("16:00");
        login.selectSubject(2);

        login.clickRegisterButton();
        login.getHistoryPage();

        login.assertConfirmation("2016-03-28"+'\n'+ "16:00:00"+'\n'+ "Antakalnio g. 45"+'\n'+ "Taupymas ir investavimas");
    }

    @Test
    public void validationTest() throws InterruptedException {
        login.getRegisterPage();
        login.waitForRegisterPage();
        login.enterName("Tester");
        login.enterSurname("");
        login.enterPhone("+37061855522");
        login.enterEmail("tester@demo.net");
        login.selectBank(2);
        login.pickDate("28");
        login.selectTime("16:00");
        login.selectSubject(2);

        login.clickRegisterButton();
        login.assertValidation("surname");
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}