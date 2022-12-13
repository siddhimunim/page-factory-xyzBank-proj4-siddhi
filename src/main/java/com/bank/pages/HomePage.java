package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin ;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin ;



    public void clickOnBankMangerLogin(){
        Reporter.log("click on bank managerLogin " + bankManagerLogin.toString() );
        mouseHoverToElementAndClick(bankManagerLogin);
        CustomListeners.test.log(Status.PASS,"click on customer log in"+ bankManagerLogin);
    }
    public void clickOnCustomerLogin(){
        Reporter.log("click on customerLogin " + customerLogin.toString() );
        mouseHoverToElementAndClick(customerLogin);
        CustomListeners.test.log(Status.PASS,"click on customerlog in"+ customerLogin);
    }



}
