package pages;

import helpers.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    By createCvButton = By.xpath("//a[@title='STWÓRZ CV W 5 MINUT']");
    By buttonCreateCVNow = By.xpath("//a[@title='Stwórz CV Teraz']");
    By templateConcept = By.xpath("//img[@alt='Szablon CV Concept']");
    By buttonStart = By.xpath("//a[@data-cy='how-it-works-cta']");
    By skipButton = By.xpath("//*[text()='Pomiń']");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void createCV(){
        driver.findElement(buttonCreateCVNow).click();
        driver.findElement(createCvButton).click();
       // WebElement element = driver.findElement(buttonStart);
       // WaitHelpers.waitForElementToBeVisible(element, driver);
      //  element.click();
       driver.findElement(buttonStart).click();
        //driver.findElement(skipButton).click();
        driver.findElement(templateConcept).click();
    }


}
