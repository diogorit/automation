package pages;

import org.openqa.selenium.WebDriver;

public class Welcome {
    WebDriver driver;

    public Welcome(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateHomePage() {
        driver.get("https://google.com/");
    }

}
