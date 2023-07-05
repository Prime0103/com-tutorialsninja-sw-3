package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility
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
    public void selectMenu(String menu){
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        String menuName ="Show AllDesktops";
        // Mouse hover on “Desktops” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"));
        // call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu(menuName);
        String expectedMessage = "Desktops";
        String actualMessage =getTextFromElement(By.xpath("//h2[normalize-space()='Desktops']"));
        // Verify the text ‘Desktops’
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        String menuName ="Show AllLaptops & Notebooks";
        // Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu(menuName);
        String expectedText = "Laptops & Notebooks";
        String actualText = getTextFromElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"));
        // Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        String menuName = "Show AllComponents";
        // Mouse hover on “Components” Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Components']"));
        // call selectMenu method and pass the menu = “Show All Components”
        selectMenu(menuName);

        String expectedMessage1 = "Components";
        String actualMessage1 = getTextFromElement(By.xpath("//h2[normalize-space()='Components']"));
        // Verify the text ‘Components’
        Assert.assertEquals(expectedMessage1,actualMessage1);

    }

    @After
    public void tearDown() {
        // Close all open tabs
        closeBrowser();
    }

}
