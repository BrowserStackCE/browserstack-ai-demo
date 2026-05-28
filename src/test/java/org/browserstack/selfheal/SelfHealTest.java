package org.browserstack.selfheal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class SelfHealTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    // @Test(priority = 1)
    public void testSetup1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://finstack-alpha.vercel.app");
        driver.findElement(By.id("email")).sendKeys("sujay.s@browserstack.com");
        driver.findElement(By.id("password")).sendKeys("BrowserStack@123");
        driver.findElement(By.id("sign_in")).click();
        wait.until(urlContains("dashboard"));
        String welcomeText = driver.findElement(By.cssSelector("h1.text-3xl")).getText();
        Assert.assertEquals(welcomeText, "Good morning, Sujay", "Incorrect login");
    }

    @Test(priority = 2)
    public void testSetup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://finstack-alpha.vercel.app");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        driver.findElement(By.id("email")).sendKeys("sujay.s@browserstack.com");
        driver.findElement(By.id("password")).sendKeys("BrowserStack@123");
        driver.findElement(By.id("sign_in")).click();
        wait.until(urlContains("dashboard"));
        String welcomeText = driver.findElement(By.cssSelector("h1.text-3xl")).getText();
        Assert.assertEquals(welcomeText, "Good morning, Sujay", "Incorrect login");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(ITestResult tr) {
        driver.quit();
    }

}
