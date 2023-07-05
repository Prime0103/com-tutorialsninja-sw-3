package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.UUID;

public class MyAccountTest extends Utility
{
    String baseurl =" http://tutorialsninja.com/demo/index.php?";
    String email;

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseurl);
    }

    /**
     * This method is used to click on any tab of my account dropdown
     */
    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        String option = "Register";
        // 3.1 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        //3.3  Enter first name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "mnb");
        //3.4  Enter Last name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "abc");
        //3.5 Enter email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"azx1@gmail.com");
        Thread.sleep(1000);
        //3.6 Enter telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "7876546345");
        //3.7 Enter password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "jkl@123");
        Thread.sleep(1000);
        //3.8 Enter confirm password
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "jkl@123");
        //3.9 Select Subscribe Yes radio button
        selectRadioButton(By.xpath("//label[normalize-space()='Yes']"));
        Thread.sleep(1000);
        //3.10 Click on Privacy Policy check box
        selectCheckBox(By.xpath("//input[@name='agree']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(1000);
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //3.13 click on continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        Thread.sleep(1000);
        //3.14 click on My Account link
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        option = "Logout";
        selectMyAccountOptions(option);
        //  Verify the text “Account Logout”
        Thread.sleep(1000);
        String expectedMessage1 = "Account Logout";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {

        //4.1 Click on My Account Link
        String option = "Login";
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "azx12@gmail.com");
        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "nkl@123");
        Thread.sleep(1000);
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String expectedMessage = "My Account";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        //4.8 Click on My Account Link.
        option = "Logout";
        Thread.sleep(1000);
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions(option);
        //4.10 Verify the text “Account Logout”
        String expectedMessage1 = "Account Logout";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        Thread.sleep(1000);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }
}
