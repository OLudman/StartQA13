package homework;

import hmwmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class HmwTestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }
}
