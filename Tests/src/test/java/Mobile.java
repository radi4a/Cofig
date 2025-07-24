import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mobile {
    public WebDriver driver;
    @Before
    public void init() {
        System.setProperty("web driver.http.factory", "jdk-http-client");
        System.setProperty("web driver.chrome.driver", "D:\\chromedriver-win64\\chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void searchSaab() throws InterruptedException {
        driver.navigate().to("https://www.mobile.bg/");
        driver.manage().window().maximize();

        WebElement agree = driver.findElement(By.id("cookiescript_accept"));
        Thread.sleep(2000);
        agree.click();

        WebElement search = driver.findElement(By.className("cat1"));
        Thread.sleep(2000);
        search.click();

        WebElement searchBy = driver.findElement(By.className("BG"));
        Thread.sleep(2000);
        searchBy.click();

        WebElement make = driver.findElement(By.name("marka"));
        Thread.sleep(2000);
        make.click();
        make.sendKeys("Saab");

        WebElement saabOption = driver.findElement(By.xpath("//span[text()='Saab']"));
        saabOption.click();

        WebElement initialSearch = driver.findElement(By.className("SEARCH_btn"));
        initialSearch.click();



    }
}
