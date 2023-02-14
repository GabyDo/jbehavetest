package mapping;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MappingStep {

    WebDriver driver;
    String googleUrl = "http://www.google.com";

    @Given("The test user open Google using Google Chrome")
    public void openGoogleHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(googleUrl);

    }

    @When("User search for key word JBehave")
    public void searchGoogleKeyword(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement eInput = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(eInput));

        eInput.sendKeys("JBehave");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));

        eInput.submit();
    }

    @Then("Assert the results include string “What is JBehave?”")
    public void assertResultReturn(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("JBehave"));

        Assertions.assertTrue(driver.getPageSource().contains("What is JBehave?"));
    }

    @AfterScenario
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}

