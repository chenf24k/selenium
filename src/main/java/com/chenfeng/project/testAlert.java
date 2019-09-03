package com.chenfeng.project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author 陈枫 on 2019-09-02.
 */
public class testAlert {
    WebDriver driver = null;
    WebElement element = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testAlert() throws InterruptedException {
        driver.get("http://47.97.253.143:5555/deploy/");
        element = driver.findElement(By.id("btn"));
        element.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(2000);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}

//((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);