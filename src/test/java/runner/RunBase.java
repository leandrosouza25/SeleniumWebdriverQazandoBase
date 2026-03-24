package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class RunBase {

    static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver getDriver(String browser) {

        if (driver != null) {
            driver.quit();
        }

        switch (browser) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                throw new IllegalArgumentException("Edge ainda nao suportado");

            default:
                throw new IllegalArgumentException("Navegador não encontrado!");
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
        }

        return driver;
    }
}
