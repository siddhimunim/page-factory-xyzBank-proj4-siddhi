package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage extends Utility {
    @CacheLookup
    @FindBy(id= "userSelect")
    WebElement searchCustomer;
    @CacheLookup
    @FindBy(xpath="//button[contains(text(),'Login')]")
    WebElement loginButton;




    public void searchCustomerNameagain(String text){
        Reporter.log("click on customer Name " + searchCustomer.toString() );
        clickOnElement(searchCustomer);
        selectByVisibleTextFromDropDown(searchCustomer,text);
        CustomListeners.test.log(Status.PASS,"click on customer name "+ text);

    }
    public void clickOnLoginButton(){
        Reporter.log("click on Login  " + loginButton.toString() );
       mouseHoverToElementAndClick(loginButton);
        CustomListeners.test.log(Status.PASS,"click on login ");
    }

}
