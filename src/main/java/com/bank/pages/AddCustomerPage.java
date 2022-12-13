package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Add Customer']")
    WebElement customerButton;

    public void clickOnFirstName(String text) {
        Reporter.log("Enter name " + text + "to name field "+ firstName.toString());
        sendTextToElement(firstName, text);
        CustomListeners.test.log(Status.PASS,"enter name " + text);

    }
    public void clickOnlastName (String text){
        Reporter.log("Enter surname " + text + "to Surname field "+ lastName.toString());
        sendTextToElement(lastName,text);
        CustomListeners.test.log(Status.PASS,"enter surname " + text);

    }
    public void clickOnPostcode (String text){
        Reporter.log("Enter postcode " + text + "to postcode field "+ postcode.toString());
        sendTextToElement(postcode,text);
        CustomListeners.test.log(Status.PASS,"enter postcode " + text);

    }
    public void clickOnAddCustomer(){
        Reporter.log("click on add customer" + customerButton.toString());
        mouseHoverToElementAndClick(customerButton);
        CustomListeners.test.log(Status.PASS,"click on add customer " );
    }
    //get text from popup
    public String verifyPopUpText(){
        return getTextFromAlert();
    }
    //accept ok ti pop up
    public void acceptpopAlert(){
        acceptAlert();
    }

}
