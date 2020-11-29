package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExperiencePage {

    private WebDriver driver;
    By inputCorporation = By.xpath("//input[@name='name']");
    By inputCity = By.xpath("//input[@name='location.city']");
By inputDateFrom = By.xpath("//input[@name='dateFrom']");

    public ExperiencePage(WebDriver driver) {

        this.driver = driver;
    }
        public void setCorporation (String corporation){
            driver.findElement(inputCorporation).sendKeys(corporation);
        }
        public void setCity (String city){
        driver.findElement(inputCity).sendKeys(city);
        }
        public  void setDateFrom (String dateFrom){
        driver.findElement(inputDateFrom).sendKeys(dateFrom);
        }
    }

