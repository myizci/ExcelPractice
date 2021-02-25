package com.practice.pages;

import com.practice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@value='male']")
    public WebElement maleButton;

    @FindBy(xpath = "//input[@value='female']")
    public WebElement femaleButton;

    @FindBy(xpath = "//input[@value='other']")
    public WebElement otherButton;

    @FindBy(xpath = "//input[@name='birthday']")
    public WebElement birthday;

    @FindBy(xpath = "//select[@name='department']")
    public WebElement departmentSelect;

    @FindBy(xpath = "(//select)[2]")
    public WebElement jobTitle;

    @FindBy(xpath = "//input[@value='cplusplus']")
    public WebElement cplusplus;

    @FindBy(xpath = "//input[@value='java']")
    public WebElement java;

    @FindBy(xpath = "//input[@value='javascript']")
    public WebElement javascript;

    @FindBy(xpath = "//button[@id='wooden_spoon']")
    public WebElement signUpButton;

    @FindBy(xpath = "//h4[text()='Well done!']")
    public WebElement wellDoneMessage;

}
