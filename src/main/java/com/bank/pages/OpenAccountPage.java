package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement custName ;
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency ;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement process ;




    public void searchCustomerName(String text) {
        Reporter.log("click on customer Name " + custName.toString() );
        clickOnElement(custName);
        selectByVisibleTextFromDropDown(custName, text);
        CustomListeners.test.log(Status.PASS,"click on customer name "+ text);
    }
    public void selectCurrencyField(String text) {
        Reporter.log("select currency  " + currency .toString() );
        clickOnElement(currency);
        selectByVisibleTextFromDropDown(currency, text);
        CustomListeners.test.log(Status.PASS,"select currency "+text);

    }
    public void clickOnProcessButton() {
        Reporter.log("click on process button  " + process .toString() );
        mouseHoverToElementAndClick(process);
        CustomListeners.test.log(Status.PASS,"click on process button  ");

    }
    //get text from popup
    public String verifyPopUpText() {
        return getTextFromAlert();
    }

    //accept ok ti pop up
    public void acceptpopAlert() {
        acceptAlert();
    }


}
