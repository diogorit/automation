package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Regist {
    WebDriver driver;

    private By dropdown = By.xpath("//div[@class='currencySelBox']/span");
    private By singIn = By.xpath("//div[@class='loginPanel']/ul/li/button");
    private By regist = By.xpath("//div[@class='loginPanel']/ul/li//div[@class='user-txt']//strong[contains(text(), 'Register')]");
    private By email = By.xpath("//div[@class='input-container']/input");
    private By next = By.xpath("//form[@name='registerForm']//button[contains(text(), 'Next')]");
    private By username = By.xpath("//input[@name='firstlastname']");
    private By phone = By.xpath("//international-phone-number[@name = 'mobileNumber']//input");
    private By password = By.xpath("//input[@name='signup_password']");
    private By select_terms = By.xpath("//div[@class='registerCheck']//label");
    private By bregist = By.xpath("//button[@class='submitButton']");
    private By done = By.xpath("//button[@class='doneButton']");
    private By firstName = By.xpath("//div[@class='userPanel']//strong");

    public Regist(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCurrency(String currency) {
        driver.findElement(dropdown).click();
        driver.findElement(By.xpath("//span[text()='" + currency + "']")).click();
    }

    public void goRegist() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(singIn)).click();
        driver.findElement(regist).click();
    }

    public void insertMail(int random) {
        driver.findElement(email).sendKeys("guest" + random + "@test.com");
        driver.findElement(next).click();
    }

    public void fieldRegist(int random) {
        WebElement userInput = driver.findElement(username);
        retryToInput(userInput, "Guest QA");
        WebElement phoneInput = driver.findElement(phone);
        retryToInput(phoneInput, "+351911234567");
        WebElement passInput = driver.findElement(password);
        retryToInput(passInput, "Username" + random);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(select_terms)).click();
        driver.findElement(bregist).click();
    }

    private void retryToInput(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
        try {
            new WebDriverWait(driver, 1).until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            System.out.println("Text in input not accordingly '" + text + "', setting again...\n");
            element.clear();
            element.sendKeys(text);
        }
    }

    public void validateRegist(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(done)).click();

        WebElement userNameDropdown = driver.findElement(firstName);
        assert userNameDropdown.getText().equals("Guest") : "Registered user 'Guest' is not the same as in home page: " + userNameDropdown.getText();
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "URL doesn't match.";
    }


}
