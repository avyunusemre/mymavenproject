package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceDropDown {
    // Create class : FaceDropdown
    // Create method : Birthday
    // https://www.facebook.com adresine gidin
    // Ay , gun ve yil dropdownlarindan istediginiz bir tarihi secin.
    // Tarayiciyi kapatin.

    @Test
    public void birthDay() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        WebElement ay = driver.findElement(By.id("month"));
        Select option = new Select(ay);
        option.selectByVisibleText("Apr");

        WebElement gun = driver.findElement(By.id("day"));
        Select optionGun = new Select(gun);
        optionGun.selectByIndex(12);

        WebElement yil = driver.findElement(By.id("year"));
        Select optionYil = new Select(yil);
        optionYil.selectByVisibleText("1992");

        driver.close();

    }

}
