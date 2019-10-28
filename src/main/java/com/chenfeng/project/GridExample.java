package com.chenfeng.project;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 陈枫 on 2019-09-03.
 */
public class GridExample {
    // 第一次测试远程构建代码
    @Test
    public void testGrid() throws MalformedURLException {
        DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
        chromeDC.setBrowserName("chrome");
        chromeDC.setPlatform(Platform.LINUX);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.79.132:5555/wd/hub/"), chromeDC);
        driver.navigate().to("https://world.xiaomawang.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
