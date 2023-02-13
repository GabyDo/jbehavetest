package mapping;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MappingStep {

    WebDriver driver;
    String localChromeDriverLocation = "/Users/dothigam/jbehavetest/resources/chromedriver";
    String googleUrl = "http://www.google.com";

    @Given("I open Google")
    public void I_open_google() {
        System.setProperty("webdriver.chrome.driver", localChromeDriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(googleUrl);

    }

    @When("I search for my blogs")
    public void I_serach_for_my_blogs(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement eInput = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(eInput));

        eInput.sendKeys("JBehave");
        eInput.submit();
    }

    @Then("I assert the URL")
    public void I_assert_the_URL(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs());

        Assertions.assertTrue(driver.getPageSource().contains("What is JBehave?"));
//        List<WebElement> resultsEntry = driver.findElements(By.cssSelector(.r));
//        driver.getPageSource()
//        for( WebElement result: resultsEntry) {
//
//        }
//
//        String currentURL = driver.getCurrentUrl();
//        Assertions.assertEquals("https://blog.knoldus.com/author/sparsh79/",currentURL);
    }
}

