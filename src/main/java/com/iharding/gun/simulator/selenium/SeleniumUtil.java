package com.iharding.gun.simulator.selenium;

import com.iharding.gun.dao.www.model.wrapper.RouteInfoWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by fyeman on 2017/9/22.
 */
public class SeleniumUtil {
    public WebDriver register(String website) throws Exception {
        //定义驱动对象为 FirefoxDriver 对象
        WebDriver driver = new FirefoxDriver();
        //驱动的网址
        driver.get(website);
        //浏览器窗口变大
        driver.manage().window().maximize();
        return driver;
    }

    public void createElement(WebDriver driver, RouteInfoWrapper routeInfoWrapper) {
        WebElement element = null;
        switch (SeleniumUtil.ElementTypeEnum.parseOfValue(routeInfoWrapper.getElementType())) {
            case ID:
                element = driver.findElement(By.id(routeInfoWrapper.getElementName()));
                break;
            case CLASS_NAME:
                element = driver.findElement(By.className(routeInfoWrapper.getElementName()));
                break;
            case LINK_TEXT:
                element = driver.findElement(By.linkText(routeInfoWrapper.getElementName()));
                break;
            case NAME:
                element = driver.findElement(By.name(routeInfoWrapper.getElementName()));
                break;
            case TAG_NAME:
                element = driver.findElement(By.tagName(routeInfoWrapper.getElementName()));
                break;
            case XPATH:
                element = driver.findElement(By.xpath(routeInfoWrapper.getElementName()));
                break;
        }
        bindElementEvent(element, routeInfoWrapper);
    }

    public void bindElementEvent(WebElement element, RouteInfoWrapper routeInfoWrapper) {
        switch (SeleniumUtil.EventTypeEnum.parseOfValue(routeInfoWrapper.getEventType())) {
            case CLICK:
                element.click();
                break;
            case SEND_KEYS:
                element.sendKeys("it's test");
                break;
        }
    }

    public enum ElementTypeEnum {
        ID("1"), CLASS_NAME("2"), LINK_TEXT("3"), NAME("4"), TAG_NAME("5"), XPATH ("6");
        private String value;
        ElementTypeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        public String toString() {
            return value;
        }

        public static SeleniumUtil.ElementTypeEnum parseOfValue(String value) {
            SeleniumUtil.ElementTypeEnum elementTypeEnum = SeleniumUtil.ElementTypeEnum.ID;
            switch (value) {
                case "1":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.ID;
                    break;
                case "2":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.CLASS_NAME;
                    break;
                case "3":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.LINK_TEXT;
                    break;
                case "4":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.NAME;
                    break;
                case "5":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.TAG_NAME;
                    break;
                case "6":
                    elementTypeEnum = SeleniumUtil.ElementTypeEnum.XPATH;
                    break;
            }
            return elementTypeEnum;
        }
    }

    public enum EventTypeEnum {
        CLICK("1"), SEND_KEYS("2");
        private String value;
        EventTypeEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        public String toString() {
            return value;
        }
        public static SeleniumUtil.EventTypeEnum parseOfValue(String value) {
            SeleniumUtil.EventTypeEnum eventTypeEnum = SeleniumUtil.EventTypeEnum.CLICK;
            switch (value) {
                case "1":
                    eventTypeEnum = SeleniumUtil.EventTypeEnum.CLICK;
                    break;
                case "2":
                    eventTypeEnum = SeleniumUtil.EventTypeEnum.SEND_KEYS;
                    break;
            }
            return eventTypeEnum;
        }
    }
}
