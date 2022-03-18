package homework;

import hmwmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class HmwTestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(HmwTestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info("Test name------------------> "+ m.getName());
    }

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of test"+ m.getName());
    }
}
