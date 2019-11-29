package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;
    private By takeTour = By.xpath("//div[@class='showmebutton']/button");
    private By skipTour = By.xpath("(//div[@class='letsskip']/button)[1]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateHomePage() {
        driver.get("https://staging.engineer.ai/home");
    }

    public void clickUntilHome(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(takeTour)).click();
        driver.findElement(skipTour).click();
    }
}
