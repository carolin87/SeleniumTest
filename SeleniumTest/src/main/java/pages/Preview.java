package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Preview {
    String locatorToName = "//*[@data-cy='builder-preview']//*[contains(text(),'%s')]";
    String locatorToEmail= "//*[@data-cy='builder-preview']//*[contains(text(),'%s')]";
    private WebDriver driver;
    public Preview (WebDriver driver){
        this.driver = driver;
    }
    public boolean isNameVisible(String name){
        boolean nameVisible;
        locatorToName = locatorToName.replace("%s", name);
        nameVisible= driver.findElement(By.xpath(locatorToName)).isDisplayed();
        return nameVisible;
    }
    public  boolean isEmailVisible (String  email){
        boolean emailVisible;
        locatorToEmail = locatorToEmail.replace("%s",email);
        emailVisible = driver.findElement(By.xpath(locatorToEmail)).isDisplayed();
        return emailVisible;
    }



}
