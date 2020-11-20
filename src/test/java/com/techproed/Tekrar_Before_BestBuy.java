package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tekrar_Before_BestBuy {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void titleTest() {
        if(driver.getTitle().contains("Best")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void logoTest() {
        WebElement bestBuyLogo = driver.findElement(By.className("logo"));

        if(bestBuyLogo.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void mexicoLinkTest() {
        WebElement mexicoLinkElement = driver.findElement(By.linkText("Mexico"));
        if(mexicoLinkElement.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
