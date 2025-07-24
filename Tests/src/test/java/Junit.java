import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junit {
    public WebDriver driver;
    @Before
    public void init(){
        System.setProperty("web driver.http.factory", "jdk-http-client");
        System.setProperty("web driver.chrome.driver", "/home/radi4a/chromedriver-linux64");
        this.driver = new ChromeDriver();
    }
    @Test
    public void Googletest(){
        driver.navigate().to("https://admirable-monstera-2bda0a.netlify.app/");
        driver.manage().window().maximize();
    }
}
