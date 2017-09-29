package support;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private WebDriver driver;

    public Driver() throws MalformedURLException {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }

        String isRemote = System.getProperty("remote");
        if (isRemote != null && "true".equals(isRemote.toLowerCase())) {
            handleRemote(browser);
        } else {
            handleLocal(browser);
        }

        driver.manage().window().maximize();
    }

    private void handleRemote(String browser) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities;

        switch (browser.toLowerCase()) {
            case "safari":
                desiredCapabilities = DesiredCapabilities.safari();
                // configure desiredCapabilities for safari
                break;
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                // configure desiredCapabilities for firefox
                break;
            case "ie":
                desiredCapabilities = DesiredCapabilities.internetExplorer();
                // configure desiredCapabilities for ie
                break;
            case "chrome":
            default:
                setChromeDriver();
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setPlatform(Platform.WINDOWS);
                break;
        }

        driver = new RemoteWebDriver(new URL(Constants.NODE_URL), desiredCapabilities);
    }

    private void handleLocal(String browser) {
        switch (browser.toLowerCase()) {
            case "safari":
                // initialize driver for safari
                break;
            case "firefox":
                // initialize driver for firefox
                break;
            case "ie":
                // initialize driver for ie
                break;
            case "chrome":
            default:
                setChromeDriver();
                driver = new ChromeDriver();
                break;
        }
    }

    private void setChromeDriver() {
        System.setProperty(Constants.CHROME_DRIVER, new File("").getAbsolutePath() + Constants.CHROME_DRIVER_PATH);
    }

    public void quit() {
        driver.quit();
    }

    public void get(String url) {
        driver.get(url);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void sendKeys(By by, String key) {
        WebElement element = driver.findElement(by);
        element.sendKeys(key);
    }
}
