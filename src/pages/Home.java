package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    WebDriver driver;
    By takeTour = By.xpath("//div[@class='showmebutton']/button");
    By skipTour = By.xpath("(//div[@class='letsskip']/button)[1]");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateHomePage() {
        driver.get("https://staging.engineer.ai/home");
    }

    public void clickUntilHome(){
        driver.findElement(takeTour).click();
        driver.findElement(skipTour).click();
    }
}
