package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton ;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement verifyLogOut  ;
   @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOut ;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
    WebElement deposit ;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement enterAmount;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement clickDeposit ;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSucess  ;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
    WebElement withdraw  ;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement withdrawAmount  ;
    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
    WebElement clickwithdraw;


    public String verifyLogOutButton(){
      Reporter.log("verify log out text " + verifyLogOut.toString() );
        CustomListeners.test.log(Status.PASS,"verify log out button");
        return getTextFromElement(verifyLogOut);

    }
    public void clickOnLogOut(){
        Reporter.log("click on log out text " + logOut.toString() );
     mouseHoverToElementAndClick(logOut);
        CustomListeners.test.log(Status.PASS,"click on log out ");
    }
    public void clickOnHomeButton(){
        Reporter.log("click on home button " + homeButton.toString() );
        mouseHoverToElementAndClick(homeButton);
        CustomListeners.test.log(Status.PASS,"click on homeButton ");
    }
    public void clickOnDeposit(){
        Reporter.log("click on deposit " + deposit.toString() );
        mouseHoverToElementAndClick(deposit);
        CustomListeners.test.log(Status.PASS,"click on deposit ");
    }
    public void enterAmountOnField(String text){
        Reporter.log("enter amount  " + text +"to amount field"+ enterAmount.toString() );
        sendTextToElement(enterAmount,text);
        CustomListeners.test.log(Status.PASS,"Enter amount  " + text );

    }
    public void clickOndepositField(){
        Reporter.log("click on deposit button " + clickDeposit.toString() );
        mouseHoverToElementAndClick(clickDeposit);
        CustomListeners.test.log(Status.PASS,"click on deposit field ");
    }
    public String verifydeposit(){
        Reporter.log("verify massage deposit sucessfull " + clickDeposit.toString() );
        CustomListeners.test.log(Status.PASS,"deposit suceesfull  "  );
        return getTextFromElement(depositSucess);
    }
    public void clickOnwithdraw(){
        Reporter.log("click on withdraw " + withdraw.toString() );
        mouseHoverToElementAndClick(withdraw);
        CustomListeners.test.log(Status.PASS,"click on withdraw ");
    }
    public void withdrawAmountOnField(String text){
        Reporter.log("withdraw amount  " + text + "from withdraw field"+ withdrawAmount.toString() );
       // clickOnElement(withdrawAmount);
        sendTextToElement(withdrawAmount,text);
        CustomListeners.test.log(Status.PASS,"withdraw amount  " + text );

    }
    public void clickOnWithdrawField(){
        Reporter.log("click on withdrawfield " + clickwithdraw.toString() );
        mouseHoverToElementAndClick(clickwithdraw);
        CustomListeners.test.log(Status.PASS,"click on withdraw ");

    }
    By withdrawSucess = By.xpath("//span[contains(text(),'Transaction successful')]");
    public String verifydwithdrawText(){
        return getTextFromElement(withdrawSucess);
    }


}
