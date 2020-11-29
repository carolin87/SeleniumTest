package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PersonalDataPage {
    By inputFirstName = By.xpath("//input[@name='firstName']");
    By inputLastName = By.xpath("//input[@name='lastName']");
    By inputFile = By.xpath("//input[@type='file']");
    By buttonZapisz = By.xpath("//*[text()='Zapisz']");
    By inputProfession = By.xpath("//input[@data-name='profession']");
    By inputEmail = By.xpath("//input[@data-builder-entry-type='PersonalContactEmail']");
    By inputPhone = By.xpath("//input[@data-builder-entry-type='PersonalContactPhone']");

    By buttonDalej = By.xpath("//*[text()='Dalej']");
    private WebDriver driver;

    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(inputFirstName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputLastName).sendKeys(surname);
    }

    public void uploadFile(String ulr) {
        driver.findElement(inputFile).sendKeys(ulr);
        driver.findElement(buttonZapisz).click();
    }

    public void setProfession(String profession) {
        driver.findElement(inputProfession).sendKeys(profession);
    }

    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void setPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }

    public void clickDalej() {
        driver.findElement(buttonDalej).click();
    }

    public boolean isNameSet(String name) {
        String valueSet = driver.findElement(inputFirstName).getAttribute("value");
        if (valueSet.equals(name)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isSurnameSet(String surname) {
        String valueSet = driver.findElement(inputLastName).getAttribute("value");
        if (valueSet.equals(surname)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmailSet(String email) {
        String valueSet = driver.findElement(inputEmail).getAttribute("value");
        if (valueSet.equals(email) && valueSet.contains("@")) {
            return true;
        }
        return false;
    }

}


