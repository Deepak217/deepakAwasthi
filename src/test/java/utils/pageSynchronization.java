package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class pageSynchronization {

    WebDriver driver;

    public pageSynchronization(WebDriver driver)
    {
        this.driver=driver;
    }

    public WebElement isElementVisible(WebElement element , int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        WebElement waitedElement=   wait.until(ExpectedConditions.visibilityOf(element));
        return waitedElement;
    }


}
