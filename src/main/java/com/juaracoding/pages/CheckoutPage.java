package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CheckoutPage {

    private WebDriver driver;
    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='billing_first_name']")
    WebElement firstname;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    WebElement lastname;
    @FindBy(xpath = "//input[@id='billing_company']")
    WebElement companyname;
    @FindBy(id = "select2-billing_country-container")
    private WebElement dropdownElement;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    WebElement billingaddress1;
    @FindBy(xpath = "//input[@id='billing_address_2']")
    WebElement billingaddress2;
    @FindBy(xpath = "//input[@id='billing_city']")
    WebElement billingcity;
    @FindBy(id = "select2-billing_state-container")
    private WebElement dropdownElement1;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    WebElement billingpostcode;
    @FindBy(xpath = "//input[@id='billing_phone']")
    WebElement billingphone;
    @FindBy(xpath = "//textarea[@id='order_comments']")
    WebElement ordercomments;
    @FindBy(xpath = "//input[@id='terms']")
    WebElement btnterms;
    @FindBy(xpath = "//button[@id='place_order']")
    WebElement btnorder;

    public void checkout(String firstname, String lastname, String companyname, String billingaddress1,
                         String billingaddress2, String billingcity, String billingpostcode,
                         String billingphone, String ordercomments) {
        this.firstname.sendKeys(firstname);
        this.lastname.sendKeys(lastname);
        this.companyname.sendKeys(companyname);
        this.billingaddress1.sendKeys(billingaddress1);
        this.billingaddress2.sendKeys(billingaddress2);
        this.billingcity.sendKeys(billingcity);
        this.billingpostcode.sendKeys(billingpostcode);
        this.billingphone.sendKeys(billingphone);
        this.ordercomments.sendKeys(ordercomments);
        btnterms.click();
        btnorder.click();
    }



}
