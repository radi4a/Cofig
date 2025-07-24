import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class WebTest {
    public WebDriver driver;
    @Before
    public void init(){
        System.setProperty("web driver.http.factory", "jdk-http-client");
        System.setProperty("web driver.chrome.driver", "D:\\chromedriver-win64\\chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void countryInfo() throws InterruptedException {


        driver.navigate().to("https://admirable-monstera-2bda0a.netlify.app/");
        driver.manage().window().maximize();
        Actions _act = new Actions(driver);

        WebElement tutorial = driver.findElement(By.id("ok"));
        Thread.sleep(2000);
        tutorial.click();

        WebElement countryPath = driver.findElement(By.id("FI"));


        Actions actions = new Actions(driver);
        actions.moveToElement(countryPath).perform();
        Thread.sleep(2000);
        countryPath.click();

        WebElement country = driver.findElement(By.id("country"));
        String countryText = country.getText(); // Вземи текста на елемента
        Assert.assertEquals("Текстът не отговаря", "Финландия", countryText);

        WebElement element = driver.findElement(By.className("close"));
        Thread.sleep(2000);
        element.click();

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void startQuiz() throws InterruptedException {
        driver.navigate().to("https://admirable-monstera-2bda0a.netlify.app/");
        driver.manage().window().maximize();
        Actions _act = new Actions(driver);

        WebElement tutorial = driver.findElement(By.id("ok"));
        Thread.sleep(2000);
        tutorial.click();

        WebElement quiz = driver.findElement(By.id("test-btn"));
        Thread.sleep(2000);
        quiz.click();

        WebElement startQuiz = driver.findElement(By.id("startBtn"));
        Thread.sleep(2000);
        startQuiz.click();

        WebElement square = driver.findElement(By.xpath("//h3"));
        Thread.sleep(2000);
        Assert.assertTrue("Елементът не е видим", square.isDisplayed());

        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void zoomIn_zoomOut() throws InterruptedException {

        driver.navigate().to("https://admirable-monstera-2bda0a.netlify.app/");
        driver.manage().window().maximize();
        Actions _act = new Actions(driver);

        WebElement tutorial = driver.findElement(By.id("ok"));
        Thread.sleep(2000);
        tutorial.click();

        WebElement svgMap = driver.findElement(By.id("svgMapId"));  // Намери SVG картата по ID

        // Приложи CSS трансформиране за зуум
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.transform = 'scale(2)';", svgMap);

        // Изчакай малко, за да можеш да наблюдаваш резултата
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.transform = 'scale(1)';", svgMap);  // Намаляване
        Thread.sleep(2000); // Изчакай още малко за ефекта

        Thread.sleep(2000);
        driver.quit();

    }


}
