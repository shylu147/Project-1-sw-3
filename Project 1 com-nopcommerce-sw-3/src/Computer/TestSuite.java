package Computer;

import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        clickOnElement(By.xpath("//select[@id='products-orderby']"));

        //Select sort by position"Name :"Z to A"
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        clickOnElement(By.xpath(" //option[contains(text(),'Name: Z to A')]"));

        //Verify the product will arrange in Descending order.
        String expectedText = "Name: Z to A";
        Assert.assertEquals("Text not Matched", expectedText, actualText);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //click on computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        //Click on a to z
        clickOnElement(By.xpath(" //option[contains(text(),'Name: A to Z')]"));
        Thread.sleep(1000);
        //Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));
        //Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("Text Matched", expectedText, actualResult);

        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown = driver.findElement(By.name("product_attribute_1"));
        Select select = new Select(dropDown);
        select.selectByValue("1");

        //Select "8GB [+$60.00]" using Select class.
        WebElement dropDown2 = driver.findElement(By.name("product_attribute_2"));
        Select select2 = new Select(dropDown2);
        select2.selectByValue("5");

        //Select HDD radio "400 GB [+$100.00]"
        driver.findElement(By.xpath("//*[@id=\"product_attribute_input_3\"]/ul/li[2]/label")).click();
        //Select OS radio "Vista Premium [+$60.00]"
        driver.findElement(By.xpath("//*[@id=\"product_attribute_input_4\"]/ul/li[2]/label")).click();

        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        driver.findElement(By.xpath("//input[@id='product_attribute_5_12']")).click();

        Thread.sleep(2500);
        //Verify the price "$1,475.00"
        String expectedPrice = "$1,475.00";
        String actualPrice = getTextFromElement(By.xpath("//*[@id=\"price-value-1\"]"));
        Assert.assertEquals("Text Matched", expectedPrice, actualPrice);

        //Click on "ADD TO CARD" Button.
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-1\"]")).click();
        //Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedText1= "The product has been added to your shopping cart";
        String actualText = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("Text Matched", expectedText1, actualText);

        //After that close the bar clicking on the cross button.
        driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]")).click();


        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"))).perform();
        driver.findElement(By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button")).click();

        //Verify the message "Shopping cart"
        String expectedShoppingCart = "Shopping cart";
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Text Matched", expectedShoppingCart, actualShoppingCart);

        //Change the Qty to "2"
        driver.findElement(By.className("qty-input")).clear();
        sendTextToElement(By.className("qty-input"), "2");

        //Click on "Update shopping cart"
        driver.findElement(By.xpath("//*[@id=\"updatecart\"]")).click();

        //Verify the Total"$2,950.00"
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong"));
        Assert.assertEquals("Text Matched", expectedTotal, actualTotal);

        //click on checkbox “I agree with the terms of service”
        driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();

        //Click on “CHECKOUT”
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        //Verify the Text “Welcome, Please Sign In!”
        String expectedSignInMessage = "Welcome, Please Sign In!";
        String actualSignInMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text Matched", expectedSignInMessage, actualSignInMessage);

        //Click on “CHECKOUT AS GUEST” Tab
        driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();

        //Add first name
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Shy");

        //Add Last name
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Birun");

        //Add email address
        sendTextToElement(By.id("BillingNewAddress_Email"), "Shy@gmail.com");


        //Select country
        WebElement dropDown3 = driver.findElement(By.name("BillingNewAddress.CountryId"));
        Select select3 = new Select(dropDown3);
        select3.selectByValue("233");

        //Add city
        sendTextToElement(By.id("BillingNewAddress_City"), "London");

        //Add address1
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Surrey");

        //Add zipcode
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "SW13 2NB");
        //Add phonenumber
        sendTextToElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[11]/input[1]\n"), "1234567890");
        //Click on Continue
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]")).click();

        //Click on Radio Button “Next Day Air($0.00)”
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[1]")).click();

        //Click on “CONTINUE”
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")).click();

        //Select Radio Button “Credit Card”
        driver.findElement(By.xpath("//label[contains(text(),'Credit Card')]")).click();

        //Click on “CONTINUE”
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")).click();

        //Select CREDIT CARD TYPE
        WebElement dropDown4 = driver.findElement(By.name("CreditCardType"));
        Select select4 = new Select(dropDown4);
        select4.selectByValue("MasterCard");

        //Add cardHolder name
        sendTextToElement(By.id("CardholderName"), "Shy");

        //Add card number
        sendTextToElement(By.id("CardNumber"), "4462383285193424");

        //Add ExpireYear
        sendTextToElement(By.id("ExpireYear"), "2024");


        //Add card number
        sendTextToElement(By.id("CardCode"), "293");

        //Click on “CONTINUE”
        driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")).click();

        //Verify “Payment Method” is “Credit Card”
        String expectedPaymentMethod = "Credit Card";
        String actualPaymentMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[1]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text Matched", expectedPaymentMethod, actualPaymentMethod);

        //Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//*[@id=\"checkout-confirm-order-load\"]/div/div/div/div/div[2]/div[2]/ul/li/span[2]"));
        Assert.assertEquals("Text not Matched", expectedShippingMethod, actualShippingMethod);

        //Verify Total is “$2,950.00”
        String expectedTotalFinal = "$2,950.00";
        String actualTotalFinal = getTextFromElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
        Assert.assertEquals("Text Matched", expectedTotalFinal, actualTotalFinal);

        //Click on “CONFIRM”
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
        //Verify the Text “Thank You”
        String expectedThanks = "Thank you";
        String actualThanks = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text Matched", expectedThanks, actualThanks);

        //Verify the message “Your order has been successfully processed!”
        String expectedOrderMessage = "Your order has been successfully processed!";
        String actualOrderMessage = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Text Matched", expectedOrderMessage, actualOrderMessage);

        //Click on “continue”
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

        //Verify the text “Welcome to our store”
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text Matched", expectedWelcomeMessage, actualWelcomeMessage);

}}