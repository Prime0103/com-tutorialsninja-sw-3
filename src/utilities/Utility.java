package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest
{
    /**
     * This method will click on method
     */

    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method is Use to send value on any element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method is used to get text from any element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method is used to  select value from drop down
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by visible text
        select.selectByVisibleText(text);

    }

    /**
     * This method will select the option by visible value
     */
    public void selectByValueFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    /**
     * This method will select the option by index
     */
    public void selectByIndexFromDropDown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(value);

    }

    /**
     * This method is used to  select radio button
     */
    public void selectRadioButton(By by) {
        driver.findElement(by).click();
    }

    /**
     * selectOptionByContainsText
     */
    public void mouseHoverToElement(By by) {
        Actions actions =new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);
        //Mouse hover to computers
        actions.moveToElement(computer).build().perform();
    }

    /**
     * mouseHover to element and click
     */
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);

        //Click on software in computer
        actions.moveToElement(software).click().build().perform();
    }

    /**
     * This method is used to select CheckBox
     */
    public void selectCheckBox(By by) {

        WebElement checkBox = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        actions.perform();
        if (checkBox.isSelected()) {

        } else {
            checkBox.click();
        }
    }


}
