package com.chenfeng.project;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈枫 on 2019-09-02.
 */
public class testCookie {
    WebDriver driver = null;
    WebElement element = null;
    String cookie = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOnsiZ3JhbnRUeXBlIjoiIiwic2NvcGUiOiIifSwiYXVkIjp7Im93bmVyIjp7ImFwcElkIjoieG13Mzg1MTIxMDY1NjkyMCIsInVjSWQiOjU4NDYwNSwiYWNjb3VudCI6IjE4NjU3MTcxMDAxIn0sInZpc2l0b3IiOiIueGlhb21hd2FuZy5jb20ifSwiZXhwIjoxNTY4MDQxNzE4fQ.DnC14K7jvZlFFJ-jSux20shVngtlqd3OMPzCoFONDZ8";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Test
    public void testCookie() throws InterruptedException {
        driver.navigate().to("https://test-world.xiaomawang.com");
        Cookie token = new Cookie("user_token", cookie);
        // 添加cookie并刷新页面完成登录
        driver.manage().addCookie(token);
        driver.navigate().refresh();
        Thread.sleep(2000);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
