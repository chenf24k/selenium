package com.chenfeng.project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 陈枫 on 2019-09-02.
 */
public class testSwitchWindows {
    WebDriver driver = null;
    WebElement element = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testSwitchWindows() throws InterruptedException {
        driver.get("https://test-world.xiaomawang.com");
        element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div[1]/a/div/img"));
        element.click();
        String currentHandle = driver.getWindowHandle();
        System.out.println("获取当期窗口句柄:" + currentHandle);
        for (String temp : driver.getWindowHandles()) {
            if (!temp.equals(currentHandle)) {
                driver.switchTo().window(temp);
                System.out.println("切换到新的窗口:" + temp);
                Thread.sleep(3000);
            }
        }
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
