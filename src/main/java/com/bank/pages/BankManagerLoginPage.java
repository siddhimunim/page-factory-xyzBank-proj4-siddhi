package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[1]")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath ="//body/div[3]/div[1]/div[2]/div[1]/div[1]/button[2]")
    WebElement clickOpenAccount;



    public void clickOnAddCustomer(){
        Reporter.log("click on bank managerLogin " + addCustomer.toString() );
        mouseHoverToElementAndClick(addCustomer);
        CustomListeners.test.log(Status.PASS,"click on manager log in"+ addCustomer);
    }
    public void clickOnOpenAccount(){
        Reporter.log("click on open account " + addCustomer.toString() );
        mouseHoverToElementAndClick(clickOpenAccount);
        CustomListeners.test.log(Status.PASS,"click on open account"+ clickOpenAccount);
    }

}
