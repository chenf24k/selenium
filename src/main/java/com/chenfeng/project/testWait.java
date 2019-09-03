package com.chenfeng.project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author 陈枫 on 2019-09-02.
 */
public class testWait {
    WebDriver driver = null;
    WebElement element = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testWait() throws InterruptedException {
        driver.get("http://47.97.253.143:5555/deploy/");
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("陈枫-小工具"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("bt2n")));
        element = driver.findElement(By.id("bt2n"));
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
