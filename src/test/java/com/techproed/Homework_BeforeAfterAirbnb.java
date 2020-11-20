package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework_BeforeAfterAirbnb {

    // Bir class oluşturun: Homework_BeforeAfterAirbnb
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının "Airbnb" içerdiğini doğrulayın
    // logoTest => Airbnb logosunun görüntülenip görüntülenmediğini doğrulayın
    // helpLinkTest => "Help" linkinin görüntülenip görüntülenmediğini doğrulayın
    // Her testten sonra tarayıcıyı kapatin

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tr.airbnb.com/");
    }

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();

        if(actualTitle.contains("Airbnb")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void logoTest() {
        WebElement logoAirbnb = driver.findElement(By.xpath("//body/div[4]/div/div/div/div[1]/div[1]/div/header/div/div[1]/a"));
        if(logoAirbnb.isDisplayed()) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    @Test
    public void helpLinkTest() {
        WebElement helpLink = driver.findElement(By.xpath("//body/div[4]/div/div/div/div/div/div/header/div/div[3]/nav/div/a[3]/div"));

        if(helpLink.isDisplayed()){
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
