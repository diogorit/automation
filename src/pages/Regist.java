package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Regist {
    WebDriver driver;

    By dropdown = By.xpath("//div[@class='currencySelBox']/span");
    By singIn = By.xpath("//div[@class='loginPanel']/ul/li/button");
    By regist = By.xpath("//div[@class='loginPanel']/ul/li//div[@class='user-txt']//strong[contains(text(), 'Register')]");
    By email = By.xpath("//div[@class='input-container']/input");
    By next = By.xpath("//form[@name='registerForm']//button[contains(text(), 'Next')]");
    By username = By.xpath("//input[@name='firstlastname']");
    By phone = By.xpath("//internacional-phone-number//input");
    By password = By.xpath("//input[@name='signup_password']");
    By select_terms = By.xpath("//div[@class='registerCheck']//label");
    By bregist = By.xpath("//button[@class='submitButton']");
    By done = By.xpath("//button[@class='doneButton']");
    By firstName = By.xpath("//div[@class='userPanel']//strong");

    public Regist(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCurrency(String currency) {
        driver.findElement(dropdown).click();
        driver.findElement(By.xpath("//span[text()='" + currency + "']")).click();
    }

    public void goRegist() {
        driver.findElement(singIn).click();
        driver.findElement(regist).click();
    }

    public void insertMail(int random) {
        driver.findElement(email).sendKeys("username" + random + "@test.com");
        driver.findElement(next).click();
    }

    public void fieldRegist(int random) {
        driver.findElement(username).sendKeys("gest" + " qa");
        driver.findElement(phone).sendKeys("911234567");
        driver.findElement(password).sendKeys("Username" + random);
        driver.findElement(select_terms).click();
        driver.findElement(bregist).click();
    }

    public void validateRegister() {
        driver.findElement(done).click();

        WebElement userDropdown = driver.findElement(firstName);
        assert userDropdown.getText().equals("Teste") : "Registered user 'Teste' is not the same as in home page: " + userDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url does not match";
    }

}
