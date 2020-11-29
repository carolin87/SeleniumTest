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
import pages.ExperiencePage;
import pages.MainPage;
import pages.NavigationPanel;
import pages.PersonalDataPage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyTest {
    private WebDriver driver;
    private PersonalDataPage personalDataPage;
    private MainPage mainPage;
    private ExperiencePage experiencePage;
    private NavigationPanel navigationPanel;

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

    }

    @After
    public void tearDown() throws Exception {
        //  driver.close();
    }

    /* @Test
     public void myTest1() throws InterruptedException {

         WebElement elementNieruchomosci = driver.findElement
                 (By.xpath("//a[@data-id='3']//*[text()='Nieruchomości']"));
         elementNieruchomosci.click();
         Thread.sleep(1000);
         WebElement elementMieszkania = driver.findElement
                 (By.xpath("//a[@data-id='1307']//*[text()='Mieszkania']"));
         elementMieszkania.click();
         Thread.sleep(1000);
         WebElement elementRodzajBudowy = driver.findElement
                 (By.xpath("//li[@data-param-id='157']//span[@class='icon down abs']"));
         elementRodzajBudowy.click();
         WebElement element = driver.findElement
                 (By.xpath("//label[@class='chbox multichbox inlblk value c27 lheight18 active-filter'][@for='f-kamienica_builttype']"));
         Actions actions = new Actions(driver);
         actions.moveToElement(element); actions.perform();

         WebElement elementKamienica = driver.findElement
                 (By.xpath("//label[@class='chbox multichbox inlblk value c27 lheight18 active-filter'][@for='f-kamienica_builttype']"));
         elementKamienica.click();
         WebElement elementPietro = driver.findElement
                 (By.xpath("//div[@class='filter-item rel filter-item-floor_select']"));
         elementPietro.click();
         WebElement elementPonad10 = driver.findElement
                 (By.xpath("//label[@class='chbox multichbox inlblk value c27 lheight18 active-filter'][@for='f-floor_11_floor_select']"));
         elementPonad10.click();
         WebElement elementPokoje = driver.findElement
                 (By.xpath("//div[@class='filter-item rel filter-item-rooms']"));
         elementPokoje.click();
         WebElement elementNieZnaleziono = driver.findElement
                 (By.xpath("//h1[@class='c41 lheight24']"));
         Assert.assertEquals(elementNieZnaleziono.getText(), "Nie znaleziono");
     }*/
    @Test
    public void TestCV() throws IOException {
        WebElement element = driver.findElement(By.xpath("//a[@title='Stwórz CV Teraz']"));
        WaitHelpers.waitForElementToBeVisible(element, driver);
        element.click();

        WaitHelpers.waitForVisibilityOfElementLocatedBy(By.xpath("//img[@alt='Szablon CV Concept']"), driver);
        WebElement element2 = driver.findElement(By.xpath("//img[@alt='Szablon CV Concept']"));
        element2.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-cy='how-it-works-cta']")));
        WebElement element3 = driver.findElement(By.xpath("//a[@data-cy='how-it-works-cta']"));
        element3.click();

        WebElement inputImie = driver.findElement(By.xpath("//input[@name='firstName']"));
        inputImie.sendKeys("Karolina");
        WebElement inputNazwisko = driver.findElement(By.xpath("//input[@name='lastName']"));
        inputNazwisko.sendKeys("Karolina");
        WebElement inpytElmo = driver.findElement(By.xpath("//input[@type='file']"));
        inpytElmo.sendKeys("C:\\Users\\marci\\Test\\SeleniumTest\\src\\main\\resources\\elmo.jpg");
        WebElement inputZapisz = driver.findElement(By.xpath("//*[text()='Zapisz']"));
        inputZapisz.click();

        // Actions builder = new Actions(driver);
        // builder.contextClick(element3).build().perform();

        // File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File("screenshoot.png"));
    }

}
