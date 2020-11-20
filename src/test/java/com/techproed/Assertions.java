package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {
    // Bir class oluşturun: BeforeAfterMethods
    // Ardından aşağıdaki adları kullanarak 3 test metodu oluşturun
    // titleTest => Sayfa başlığının “Google” oldugunu doğrulayın
    // imageTest => Google resminin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    // gmailLinkTest => "Gmail" linkinin görüntülenip görüntülenmediğini (isDisplayed()) doğrulayın
    // Her testten sonra tarayıcıyı kapatin
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        //Yavas web siteleri icin implicitly wait kullanilabilir.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        //Assert JUnit'ten olur.
        //Karsilastirilan String'ler aynı Test Pass olur.
        //Stringler farkliysa Test Fail olur.
        Assert.assertEquals(expectedTitle,actualTitle);

      //  if(actualTitle.equals(expectedTitle)){
      //     System.out.println("PASS");
      //  }else{
      //      System.out.println("FAIL");
      //  }

    }

    @Test
    public void imageTest(){
        // Google image locate
        WebElement googleImage = driver.findElement(By.id("hplogo"));
        // assertTrue() => googleImage.isDisplayed() true ise test Pass olur, false ise test Fail olur.
        Assert.assertTrue(googleImage.isDisplayed());

    }

    @Test
    public void gmailLinkTest(){
        //Locate gmail link element
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        Assert.assertTrue(gmailLink.isDisplayed());
    }

    @After
    public void tearDown(){
        //@After annotation'i genellikle tarayiciyi kapatmak icin kullanilir.
        //Bu metot her @Test den sonra calisir.
        driver.close();
    }
}
