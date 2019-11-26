package pages;

import org.openqa.selenium.WebDriver;

public class Home {
    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateHomePage() {
        driver.get("https://google.com/");
    }

}
