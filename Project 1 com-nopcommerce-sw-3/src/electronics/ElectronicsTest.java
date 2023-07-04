package electronics;

import homepage.BaseTest;
import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonePageSuccessFully() {
        //Mouse Hover on “Electronics” Tab
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"))).perform();
        // Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
        //Verify the text “Cell phones”
        String expectedCellPhone = "Cell phones";
        String actualCellPhone = getTextFromElement(By.xpath("  //li[@class='active last']//a[normalize-space()='Cell phones']"));
        Assert.assertEquals("Text not  Matched", expectedCellPhone, actualCellPhone);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics”
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"))).perform();

        //Mouse Hover on “Cell phones” and click
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();

        //Verify the text “Cell phones”
        String expectedcellphone = "Cell phones";
        String actualcellphone = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("Text Matched", expectedcellphone, actualcellphone);

        //Click on List View Tab
        driver.findElement(By.xpath("//a[contains(text(),'List')]")).click();

        Thread.sleep(1000);
        //Click on product name “Nokia Lumia 1020” link
        WebElement nokiaLink = driver.findElement(By.linkText("Nokia Lumia 1020"));
        nokiaLink.click();


        //Verify the text “Nokia Lumia 1020”
        String expectednokialumia = "Nokia Lumia 1020";
        String actualnokialumia = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text Matched", expectednokialumia, actualnokialumia);

        //Verify the price “$349.00”
        String expectednokialumiaprice = "$349.00";
        String actualnokialumiaprice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Text Matched", expectednokialumiaprice, actualnokialumiaprice);

        //Change quantity to 2
        driver.findElement(By.name("addtocart_20.EnteredQuantity")).clear();
        sendTextToElement(By.name("addtocart_20.EnteredQuantity"), "2");

        //Click on “ADD TO CART” tab
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-20\"]")).click();


        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedProAdded = "The product has been added to your shopping cart";
        String actualProAdded = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Text Matched", expectedProAdded, actualProAdded);


        //After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();

        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button")).click();

        //Verify the message "Shopping cart"
        String expectedShoppingCart = "Shopping cart";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expectedShoppingCart, actualShoppingCart);


        //Verify the quantity is 2



        Thread.sleep(2500);

        //Verify the Total $698.00
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[6]/span"));
        Assert.assertEquals("Text Matched", expectedTotalPrice, actualTotalPrice);

        //click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[3]/label")).click();

        //Click on “CHECKOUT”
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //Verify the Text “Welcome, Please Sign In!”
        String expectedSignInMessage1 = "Welcome, Please Sign In!";
        String actualSignInMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text Matched", expectedSignInMessage1, actualSignInMessage1);

        //Click on “REGISTER” tab
        driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();

        //Verify the text “Register”
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Text Matched",expectedRegister , actualRegister);
        //Fill the mandatory fields

        //Add first name
        sendTextToElement(By.id("FirstName"), "Shy");
        //Add Last name
        sendTextToElement(By.id("LastName"), "Birun");
        //Add email address Password
        sendTextToElement(By.id("Email"), "shyy1@gmail.com");
        //Add Password
        sendTextToElement(By.id("Password"), "shy123");
        // Conform Password
        sendTextToElement(By.id("ConfirmPassword"), "shy123");


        //Click on “REGISTER” Button
        driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();

        //Verify the message “Your registration completed” //div[@class='result']
        String expectedRegisterText = "Your registration completed";
        String actualRegisterText = getTextFromElement(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Text Matched",expectedRegisterText , actualRegisterText);

        //Click on “CONTINUE” tab
        driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();

        //Verify the text “Shopping card”
        String expectedShoppingCard = "Shopping cart";
        String actualShoppingCard = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text not  Matched", expectedShoppingCard, actualShoppingCard);

    }}
