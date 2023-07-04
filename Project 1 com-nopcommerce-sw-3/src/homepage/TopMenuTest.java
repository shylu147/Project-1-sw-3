package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class TopMenuTest extends Utility{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu){
        clickOnElement(By.linkText(menu));
    }
    @Test
    public void verifyPageNavigation()
    {
        selectMenu("Computers ");

        //Find expected element
        String actualResult=getTextFromElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        String expectedText="Computers";

        //Verify expected and actual text
        Assert.assertEquals("Text Matched",expectedText,actualResult);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
