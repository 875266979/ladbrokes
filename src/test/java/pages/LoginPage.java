package pages;

import org.openqa.selenium.By;
import support.Constants;
import support.Driver;
import support.ElementMap;

public class LoginPage {
    private final Driver driver;
    private By username;
    private By password;

    public LoginPage(Driver driver) throws Exception {
        this.driver = driver;
        username = ElementMap.getLocator(Constants.Login_Page.USERNAME);
        password = ElementMap.getLocator(Constants.Login_Page.PASSWORD);
    }

    public boolean isPagePresent() {
        return  driver.isElementPresent(username);
    }

    public void fillCredencials(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    private void setUsername(String username) {
        driver.sendKeys(this.username, username);
    }

    private void setPassword(String password) {
        driver.sendKeys(this.password, password);
    }
}
