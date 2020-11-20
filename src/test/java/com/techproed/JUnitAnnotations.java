package com.techproed;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotations {
    //Bir JUnit projesinde testi calistirmak icin @Test annotation'i kullaniriz.
    //"test1" adinda bir void method olusturun


    @Before //Her @Test'den once calisir.
    public void runBeforeTest() {
        System.out.println("@Before => run before test");
    }

    @Test //@Test test caseleri main metod olmadan calistirmamizi saglar.
    public void test1() {
        System.out.println("Test1'i yazdir.");
    }


    @Test
    public void test2() {
        System.out.println("Test2'yi yazdir");
    }

    @Ignore
    @Test
    public void test3() {
        System.out.println("Test3'u yazdir.");
    }

    @After //Her @Test'ten sonra calisir.
    public void runAfterTest() {
        System.out.println("@After => run after test");
    }
}
