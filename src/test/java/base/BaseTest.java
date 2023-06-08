package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTest {
    protected HomePage homePage;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(375, 812)); // assign a size to the window
        //System.out.println(driver.getTitle());

        homePage = new HomePage(driver);

        /*
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputLink = driver.findElement(By.linkText("Inputs"));
        inputLink.click();*/

        //driver.close();//close the browser
        //driver.quit() //close any browser window opened
    }
    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    /*
    public static void main(String args[]){
        BaseTest baseTest = new BaseTest();
        baseTest.setUp();
    }*/
}
