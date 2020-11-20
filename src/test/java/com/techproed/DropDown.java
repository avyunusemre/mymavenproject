package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {
    //Bir class oluşturun: DropDown
    //https://the-internet.herokuapp.com/dropdown adresine gidin.
    //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //4.Tüm dropdown değerleri(value) yazdırın
    //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropDownTest() {
        //Dropdown icin Select class'i kullanilir.
        WebElement selectElement = driver.findElement(By.id("dropdown"));
        //Select class'inda obje olusturup, selectelementi pass edelim
        Select options = new Select(driver.findElement(By.id("dropdown")));
        //Artik olusturulan objecti dropdown'a ulasmak icin kullanabiliriz.
        String firstOption = options.getFirstSelectedOption().getText();
        //getFirstSelectedOption() =>dropdown'daki default value'yu return eder.
        System.out.println(firstOption);

        //Dropdownd'da element belirlemenin 3 yolu var:
        //             1)index'le ==> selectByIndex("");
        //             2)value ile ==> selectByValue("");
        //             3)Visible text ile ==> selectByVisibleText("");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //===========SELECT BY INDEX=========
        options.selectByIndex(1);


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> allOptions = options.getOptions();

        for(WebElement element : allOptions) {
            System.out.println(element.getText());
        }

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int size = allOptions.size();

        //1. YOL
        //if(size==4) {
        //    System.out.println("TRUE");
        //} else {
        //    System.out.println("FALSE");
        //}

        //2.YOL
        //assertion kullanarak
        Assert.assertFalse(size == 4);



        System.out.println((size==4 ) ? true : false);

    }
}
