package org.browserstack.selfheal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SelfHealTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void selfHeal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://shashankg-gollapally.github.io/Automate_Selfheal_Pages/index.html");
        Select pageSelector = new Select(wait.until(elementToBeClickable(By.id("page-selector"))));
        pageSelector.selectByVisibleText("Element attribute modified page");
        wait.until(elementToBeClickable(By.id("username"))).sendKeys("test123");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(ITestResult tr) {
        driver.quit();
    }

}
