package com.chenfeng.project;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 陈枫 on 2019-09-02.
 */
public class testTakesScreenshot {
    WebDriver driver = null;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testTakesScreenshot() throws IOException {
        driver.get("https://www.baidu.com");
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File(System.getProperty("user.dir") + "\\file\\screen.png"));
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
