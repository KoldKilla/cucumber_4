package manager;

import org.apache.commons.exec.OS;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import manager.TestPropManager;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;


public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

   private final TestPropManager props = TestPropManager.getTestPropManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private void initDriver() {
        if ("remote".equalsIgnoreCase(props.getProperty("driver.type"))) {
            initRemoteDriver();
        } else {
            if (OS.isFamilyWindows()) {
                initDriverWindowsOsFamily();
            }
        }
    }

    /**
     * Метод инициализирующий веб драйвер под ОС семейства Windows
     */
    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily("path.gecko.driver.windows", "path.chrome.driver.windows");
    }

    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (props.getProperty("type.browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", props.getProperty(gecko));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", props.getProperty(chrome));
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("Типа браузера '" + props.getProperty("type.browser") + "' не существует во фреймворке");
        }
    }

    private void initRemoteDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName",props.getProperty("type.browser"));
        capabilities.setCapability("browserVersion","109.0");
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC",true);
        selenoidOptions.put("enableVideo",false);
        capabilities.setCapability("selenoid:options",selenoidOptions);
        try {
            driver = new RemoteWebDriver(URI.create(props.getProperty("selenoid.url")).toURL(),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}

