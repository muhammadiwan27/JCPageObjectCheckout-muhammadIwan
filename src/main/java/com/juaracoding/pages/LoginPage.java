package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/div[2]/div[1]/form/p[1]/input")
    WebElement username;
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/div[2]/div[1]/form/p[2]/span/input")
    WebElement password;
    @FindBy(xpath = "/html/body/div[1]/div[2]/main/article/div/div/div[2]/div[1]/form/p[3]/button")
    WebElement btnLogin;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }



}
