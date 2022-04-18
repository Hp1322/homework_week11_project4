package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValid(){

        //Find email field element
        WebElement emailField = driver.findElement(By.name("user-name"));
        //Sending email to email field
        emailField.sendKeys("standard_user");

        //Find password field element
        WebElement passwordField = driver.findElement(By.id("password"));
        //Sending password to password field
        passwordField.sendKeys("secret_sauce");

        //Find login link and click on it
        WebElement loginLink = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink.click();

        //Verify the text “PRODUCTS”
        //This is from requirement
        String expectedMessage = "PRODUCTS";

        //actual message
        WebElement actual = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        String actualMessage = actual.getText();

        //Valiadte expected message and actual message
        Assert.assertEquals("unable to navigate on product page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Find email field element
        WebElement emailField = driver.findElement(By.name("user-name"));
        //Sending email to email field
        emailField.sendKeys("standard_user");

        //Find password field element
        WebElement passwordField = driver.findElement(By.id("password"));
        //Sending password to password field
        passwordField.sendKeys("secret_sauce");

        //Find login link and click on it
        WebElement loginLink = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink.click();

        //Verify that six products are displayed on page
        //This is from requirement
        int expectedMessage = 6;

        List<WebElement> productName = driver.findElements(By.className("inventory_item"));
        int size = productName.size();
        System.out.println(size);//6

        //Validate expected and actual message
        Assert.assertEquals("unable to display 6 products", expectedMessage, size);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
