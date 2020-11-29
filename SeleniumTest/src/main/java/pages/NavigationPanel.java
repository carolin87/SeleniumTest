package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    private WebDriver driver;

    By PersonalDataButton = By.xpath("//*[text()='Dane osobowe']");
By ExperienceButton = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div/div[1]/div[1]/div/a[2]/span");
By EducationButton = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div/div[1]/div[1]/div/a[3]/span");
By SkillsButton = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div/div[1]/div[1]/div/a[4]/span");
By SkillsButton2 = By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[1]/div/div/a[4]/div");
public NavigationPanel (WebDriver driver){
    this.driver= driver;
}
public void selectPersonalData(){
    driver.findElement(PersonalDataButton).click();
}
public void selectEducation(){
    driver.findElement(EducationButton).click();
}
public void selectExperience(){
    driver.findElement(ExperienceButton).click();
}
public void  selectSkills(){
    driver.findElement(SkillsButton).click();
   // if (navigationPanelAtTop=driver.findElements(SkillsButton).size() < 1);
   // driver.findElement(SkillsButton2).click();
}
}
