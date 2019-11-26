package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Regist {
    WebDriver driver;

    By dropdown = By.xpath("//div[@class='currencySelBox']/span");
    By singIn   = By.xpath("//div[@class='loginPanel']/ul/li/button");
        By regist = By.xpath("//div[@class='loginPanel']/ul/li//div[@class='user-txt']//strong[contains(text(), 'Register')]");
        By email = By.xpath("//div[@class='input-container']/input");
        By next = By.xpath("//form[@name='registerForm']//button[contains(text(), 'Next')]");
By username = By.xpath("//input[@name='firstlastname']");
    public Regist(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCurrency(String currency) {
        driver.findElement(dropdown).click();
        driver.findElement(By.xpath("//span[text()='" + currency + "']")).click();
    }

    public void goRegist(){
        driver.findElement(singIn).click();
        driver.findElement(regist).click();
    }

    public void insertMail(int random){
        driver.findElement(email).sendKeys("username"+random+"@test.com");
        driver.findElement(next);
    }

    public void fieldRegist(int radom){
        driver.findElement(username).sendKeys("gest"+ " qa");
    }

}
