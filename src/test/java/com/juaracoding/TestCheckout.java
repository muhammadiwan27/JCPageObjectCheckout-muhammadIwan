package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCheckout {

    static WebDriver driver;
    static LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");

        loginPage = new LoginPage();
    }

    @AfterClass
    public void closeBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        loginPage.login("muhammadiwan27","Iwan12345!@#$%");
        delay(1);
    }

    @Test(priority = 2)
    public void testInvalidLogin(){
        loginPage.login("Admin","admin1234");
        delay(1);
    }

    @Test(priority = 3)
    public void testValidCheckout(){
        CheckoutPage.checkout("Muhammad","Iwan","Juara Coding", "Jakarta",
                "Bandung", "Jakarta", "25223", "082285477825",
                "Pengiriman Cepat");
        delay(1);
    }

    static void delay(long detik) {
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
