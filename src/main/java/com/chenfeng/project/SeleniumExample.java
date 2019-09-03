package com.chenfeng.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author 陈枫 on 2019-08-16.
 */
public class SeleniumExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https:www.baidu.com");
        System.out.println(driver.getTitle());
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("Hello,Selenium");
        WebElement button = driver.findElement(By.id("su"));
        button.submit();
        driver.quit();
    }
}
