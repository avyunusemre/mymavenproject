package com.techproed;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstMavenClass {

    public static void main(String[] args) {
        //Maven projesinde System.setProperty("",""); kullanmayiz.
        // Bunun yerine WebDriverManager kullaniriz.
        //chrome driver icin;
        WebDriverManager.chromedriver().setup(); //kirmizi olmasinin sebebi eksik dependency lerin olmasindandir.
        //Dependency ler nereden alinir???  https://mvnrepository.com/ git ve WebDriverManager ara
        WebDriver driver = new ChromeDriver();  //https://mvnrepository.com/ git ve selenium java ara
        driver.get("https://www.google.com");

        //Fake data nasil olusturulur?
            //Fake data olusturmak icin "JavaFaker" denilern bir dependency gerekir.
        //searchBox elementini locate edin
        WebElement searchBox = driver.findElement(By.name("q"));

        //faker objecti olusturur
        Faker faker = new Faker();
        //searchBox.sendKeys(faker.name().fullName() + Keys.ENTER);
        searchBox.sendKeys(faker.name().fullName());
        searchBox.submit();

        System.out.println(faker.country().capital());
    }
}

