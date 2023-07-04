package homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest{

    /**
     * This method will click on element
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);}

    //select methods 3
    //3.1 select by visible text
    public void visibleTextDropDown(By by,String text){
        WebElement dropdown=driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByVisibleText(text);}
    //3.2 Select by value
    public void valueDropDown(By by,String text){
        WebElement dropdown=driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByValue(text);}

    //3.3 select by index
    public void indexDropDown(By by,int index){
        WebElement dropdown=driver.findElement(by);
        Select select=new Select(dropdown);
        select.selectByIndex(index);}


    /**
     * Action -------This method will mouseHover on the element
     * */
    public void mouseHover(By by1,By by2){
        //Computer ------> Software  and click
        WebElement text1= driver.findElement(by1);
        WebElement text2= driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.moveToElement(text1).moveToElement(text2).click().build().perform();
    }
    public void mouseHoverAndClick(By by){
        //Computer ------> Software  and click
        Actions actions = new Actions(driver);
        WebElement webElement= driver.findElement(by);
        actions.moveToElement(webElement).click().build().perform();

    }}