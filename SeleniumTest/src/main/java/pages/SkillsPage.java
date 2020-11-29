package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SkillsPage {
    private WebDriver driver;

    By WorkInTeamSkill = By.xpath("//*[text()='Umiejętność pracy w zespole']");
    By ExperienceLevelSwitch = By.xpath("//input[@name='rating']");
    By ExperienceLevelStars = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/div[3]/div/div[2]");

    public SkillsPage(WebDriver driver) {
        this.driver = driver;
    }
    public  void switchOffExperienceLevel(){
        driver.findElement(ExperienceLevelSwitch).click();
    }
   public boolean isExperienceLevelIsOff(){
        boolean experiencelevelOff;
        experiencelevelOff=driver.findElements(ExperienceLevelStars).size() < 1;
        return  experiencelevelOff;

    }
    public  void addWorkInTeamSkill(){
        driver.findElement(WorkInTeamSkill).click();
    }
}
