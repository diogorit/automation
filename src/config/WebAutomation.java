package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class WebAutomation {
    public static WebDriver driver;

    public static void main(String[] args) {
        driver = openBrowser("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Home home = new Home(driver);
        home.NavigateHomePage();

        driver.close();
    }

    public static WebDriver openBrowser(String browser) {
        WebDriver driver = null;

        try {
            switch (browser) {
                case ("Chrome") :
                    System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
                    driver = new ChromeDriver(); break;
                case ("Firefox"):
                    System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
                    driver = new FirefoxDriver(); break;
                default:
                    System.out.println("Expected value: Firefox or Chrome");
            }
            return driver;
        } catch (Exception E) {
            E.printStackTrace();
        }
        return driver;
    }
}
