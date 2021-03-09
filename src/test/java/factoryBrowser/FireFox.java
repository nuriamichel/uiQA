package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FireFox implements IBrowser {
    public WebDriver create() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefoxDriver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
