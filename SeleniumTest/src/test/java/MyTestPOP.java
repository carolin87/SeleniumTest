import helpers.WaitHelpers;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyTestPOP {
    private WebDriver driver;
    private PersonalDataPage personalDataPage;
    private MainPage mainPage;
    private ExperiencePage experiencePage;
    private NavigationPanel navigationPanel;
    private Preview preview;
    private SkillsPage skillsPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://interviewme.pl/");
        driver.manage().window().maximize();
        // driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler'][text()='Akceptuję']")).click();

        mainPage = new MainPage(driver);
        personalDataPage = new PersonalDataPage(driver);
        experiencePage = new ExperiencePage(driver);
        preview = new Preview(driver);
        navigationPanel = new NavigationPanel(driver);
        skillsPage = new SkillsPage(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void TestCV() throws IOException {
        mainPage.createCV();
        personalDataPage.setName("Karo");
        personalDataPage.setSurname("Kud");
        Assert.assertTrue(personalDataPage.isNameSet("Karo"));
        Assert.assertTrue(personalDataPage.isSurnameSet("Kud"));
        personalDataPage.uploadFile("C:\\Users\\marci\\Test\\SeleniumTest\\src\\main\\resources\\elmo.jpg");
        personalDataPage.setProfession("biotechnolog");
        personalDataPage.setEmail("karo@gamil.com");
        Assert.assertTrue(personalDataPage.isEmailSet("karo@gamil.com"));
        personalDataPage.setPhone("500024814");
        personalDataPage.clickDalej();
        experiencePage.setCorporation("US");
        experiencePage.setCity("Katowice");
       /// experiencePage.setDateFrom("201012");
        Assert.assertTrue(preview.isNameVisible("Karo"));
        Assert.assertTrue(preview.isEmailVisible("karo@gamil.com"));
        navigationPanel.selectSkills();
        skillsPage.switchOffExperienceLevel();
        skillsPage.addWorkInTeamSkill();
        skillsPage.isExperienceLevelIsOff();
    }


}