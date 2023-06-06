package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com/my-account/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        LoginPage loginPage = new LoginPage();
        loginPage.login("muhammadiwan27","Iwan12345!@#$%");
        System.out.println("Login Succesful");

        driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/div/div/a/img")).click();
        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[2]/div/div/div/div[2]/div[2]/div[2]")).click();

        js.executeScript("window.scrollBy(0,750)");
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"pa_color\"]"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByIndex(1);
        System.out.println("Item Color Has Been Selected");

        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"pa_size\"]"));
        Select selectDropdown1 = new Select(dropdown1);
        selectDropdown1.selectByIndex(3);
        System.out.println("Item Size Has Been Selected");

        driver.findElement(By.xpath("//*[@id=\"product-1491\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        System.out.println("Item Has Been Added To The Cart");

        driver.get("https://shop.demoqa.com/checkout/");
        js.executeScript("window.scrollBy(0,500)");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout("Muhammad","Iwan","Juara Coding", "Jakarta",
                "Bandung", "Jakarta", "25223", "082285477825",
                "Pengiriman Cepat");
        js.executeScript("window.scrollBy(0,0)");
        System.out.println("Checkout Succesful");




        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        DriverSingleton.closeObjectInstance();
    }
}