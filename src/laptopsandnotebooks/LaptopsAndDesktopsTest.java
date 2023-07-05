package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndDesktopsTest extends Utility
{
    String baseurl =" http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        // Open browser and launch Url
        openBrowser(baseurl);
    }

    /**
     * This method is used to select menu
     */
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        selectMenu(menuName);
        Thread.sleep(1000);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order

    }

    @Test
    public void  verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        Thread.sleep(1000);
        selectMenu(menuName);
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));
        Thread.sleep(1000);
        //2.5 Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(1000);
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedMessage1 = "Success: You have added MacBook to your shopping cart!";
        String actualMessage1 = getTextFromElement(By.xpath("//body/div[@id='product-product']/div[1]"));
        //xpath//div[contains(text(),'Success: You have added ')]
        Assert.assertEquals(expectedMessage1,actualMessage1);
        Thread.sleep(1000);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//h1[contains(text(),'Shopping Cart ')]"));
        Thread.sleep(1000);
        //2.9 Verify the text "Shopping Cart"
        String expectedMessage2 = "Shopping Cart  (0.00kg)";
        String actualMessage2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart ')]"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        Thread.sleep(1000);
        //2.10 Verify the Product name "MacBook"
        String  expectedMessage3 = "MacBook";
        String actualMessage3 = getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals(expectedMessage3, actualMessage3);
        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//input[@name='quantity[31872]']")).clear();
        sendTextToElement(By.xpath("//input[contains(@name,'quantity ')]"), "2");
        Thread.sleep(1000);
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String expectedMessage4 = "Success: You have modified your shopping cart!\n";
        String actualMessage4 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals(expectedMessage4,actualMessage4);
        Thread.sleep(1000);
        //2.14 Verify the Total £737.45
        String expectedMessage5 = "$1,204.00";
        String actualMessage5 = getTextFromElement(By.xpath("(//td[@class='text-right'][normalize-space()='$1,204.00'])[3]"));
        Assert.assertEquals(expectedMessage5, actualMessage5);
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        String expectedMessage6 = "Checkout";
        String actualMessage6 = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals(expectedMessage6, actualMessage6);
        //2.17 Verify the Text “New Customer”
        String expectedtext = "New Customer";
        String actualtext = getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals(expectedtext,actualtext);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "khushi");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "patel");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "abc123@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07878909865");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "london road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "we3 6er");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "England");
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "My mackBook");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        Thread.sleep(1000);
        String expectedtxt = "Warning: Payment method required!";
        String actualtxt = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals(expectedtxt,actualtxt);



    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }
}
