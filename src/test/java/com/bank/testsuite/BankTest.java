package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class BankTest extends BaseTest {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerPage customerPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void Init() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerPage = new CustomerPage();
        accountPage = new AccountPage();

    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.clickOnFirstName("jenna");
        addCustomerPage.clickOnlastName("thaker");
        addCustomerPage.clickOnPostcode("CV4 5ER");
        addCustomerPage.clickOnAddCustomer();
        Assert.assertTrue(addCustomerPage.verifyPopUpText().contains("Customer added successfully"));
        addCustomerPage.acceptpopAlert();
    }


    @Test (groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        Thread.sleep(500);
        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.clickOnFirstName("jenna");
        addCustomerPage.clickOnlastName("thaker");
        addCustomerPage.clickOnPostcode("CV4 5ER");
        addCustomerPage.clickOnAddCustomer();
        addCustomerPage.acceptpopAlert();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("jenna thaker");
        openAccountPage.selectCurrencyField("Pound");
        openAccountPage.clickOnProcessButton();

        Assert.assertTrue(openAccountPage.verifyPopUpText().contains("Account created successfully"));
        openAccountPage.acceptpopAlert();

    }

    @Test (groups = {"regression"})
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.clickOnFirstName("jenna");
        addCustomerPage.clickOnlastName("thaker");
        addCustomerPage.clickOnPostcode("CV4 5ER");
        addCustomerPage.clickOnAddCustomer();
        addCustomerPage.acceptpopAlert();

        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("jenna thaker");
        openAccountPage.selectCurrencyField("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.acceptpopAlert();
        accountPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        Thread.sleep(500);
        customerPage.searchCustomerNameagain("jenna thaker");
        customerPage.clickOnLoginButton();
        Thread.sleep(1500);
        Assert.assertEquals(accountPage.verifyLogOutButton(), "Logout", "Not verify");
        accountPage.clickOnLogOut();


    }

    @Test (groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.clickOnFirstName("jenna");
        addCustomerPage.clickOnlastName("thaker");
        addCustomerPage.clickOnPostcode("CV4 5ER");
        addCustomerPage.clickOnAddCustomer();
        addCustomerPage.acceptpopAlert();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("jenna thaker");
        openAccountPage.selectCurrencyField("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.acceptpopAlert();
        accountPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerPage.searchCustomerNameagain("jenna thaker");
        customerPage.clickOnLoginButton();
        accountPage.clickOnDeposit();
        accountPage.enterAmountOnField("100");
        accountPage.clickOndepositField();
        Assert.assertEquals(accountPage.verifydeposit(), "Deposit Successful");

    }

    @Test (groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{

        homePage.clickOnBankMangerLogin();
        bankManagerLoginPage.clickOnAddCustomer();
        addCustomerPage.clickOnFirstName("jenna");
        addCustomerPage.clickOnlastName("thaker");
        addCustomerPage.clickOnPostcode("CV4 5ER");
        addCustomerPage.clickOnAddCustomer();
        addCustomerPage.acceptpopAlert();
        bankManagerLoginPage.clickOnOpenAccount();
        openAccountPage.searchCustomerName("jenna thaker");
        openAccountPage.selectCurrencyField("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.acceptpopAlert();
        accountPage.clickOnHomeButton();
        homePage.clickOnCustomerLogin();
        customerPage.searchCustomerNameagain("jenna thaker");
        customerPage.clickOnLoginButton();
        accountPage.clickOnDeposit();
        accountPage.enterAmountOnField("100");
        accountPage.clickOndepositField();

        Thread.sleep(1500);

        accountPage.clickOnwithdraw();
        Thread.sleep(1500);
        accountPage.withdrawAmountOnField("50");
        accountPage.clickOnWithdrawField();
        Assert.assertEquals(accountPage.verifydwithdrawText(),"Transaction successful");



    }
}








