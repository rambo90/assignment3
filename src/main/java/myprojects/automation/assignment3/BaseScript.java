package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.EventHandler;
import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseScript {

    public static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", new File(BaseScript.class.getResource("/geckodriver.exe").getFile()).getPath());
                return new FirefoxDriver();
            case "internet explorer":
                System.setProperty("webdriver.ie.driver", new File(BaseScript.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                return new InternetExplorerDriver();
            default:
                System.setProperty("webdriver.chrome.driver", new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new EventHandler());
        return eventFiringWebDriver;
    }
}
