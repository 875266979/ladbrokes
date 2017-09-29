package assessment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import support.Constants;
import support.Driver;
import support.TestServer;

public class WebTest {
    private TestServer server;
    private Driver driver;
    private LoginPage loginPage;

    @Before
    public void setUP() throws Exception {
        server = new TestServer(9988);
        server.start();

        driver = new Driver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
        driver.quit();
    }

    @Test
    public void testTableInput() throws Exception {
        getLoginPage();
        Assert.assertTrue(loginPage.isPagePresent());
        loginPage.fillCredencials(Constants.Login_Page.USERNAME_VALUE, Constants.Login_Page.PASSWORD_VALUE);
    }

    private void getLoginPage() {
        driver.get(Constants.LOGIN_PAGE_URL);
    }
}
