package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //clicking the sign in link
        clickOnElement(By.linkText("Sign In"));
        //sending email fields
        sendTextToElement(By.id("user[email]"), "prime@gmail.com");
        //sending password field
        sendTextToElement(By.name("user[password]"), "abcd123");
        //comparing the expected and actual results
        verifyElement("Messages does not match", "Welcome Back!", By.xpath("//h1[contains(text(),'Welcome Back!')]"));

    }

    @Test
    public void verifyTheErrorMessage() {

        clickOnElement(By.linkText("Sign In"));

        //sending the wrong email id and checking
        sendTextToElement(By.id("user[email]"), "xyz890@gmail.com");

        //sending password fields
        sendTextToElement(By.name("user[password]"), "xyz123");

        //clicking on submit button
        clickOnElement(By.cssSelector("input[value='Sign in']"));
        verifyElement("message not displayed", "Invalid email or password.", By.xpath("//li[contains(text(),'Invalid email or password.')]"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}
