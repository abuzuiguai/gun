package com.iharding.gun.proxy;

import com.iharding.gun.model.PageDataInput;
import com.iharding.gun.model.PageDataOutput;
import com.iharding.gun.util.Configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.stereotype.Component;

/**
 * Created by fyeman on 2017/9/20.
 */
@Component(value="blackAnalyzerPC")
public class BlackAnalyzerPC extends BlackAnalyzer {
    public PageDataOutput analyze(PageDataInput input, PageDataOutput output) throws Exception {
        System.setProperty("webdriver.firefox.bin", Configuration.getProperty("webdriver.firefox.bin"));
        System.setProperty("webdriver.gecko.driver",Configuration.getProperty("webdriver.gecko.driver"));
//		driver.get("https://www.jd.com/");
        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new FirefoxDriver();
        //驱动的网址
        driver.get("https://www.jd.com/");
        //浏览器窗口变大
        driver.manage().window().maximize();
        //定位输入框元素
        WebElement element = driver.findElement(By.className("link-login"));
        element.click();

        element = driver.findElement(By.linkText("账户登录"));
        element.click();

        return null;
    }
}
