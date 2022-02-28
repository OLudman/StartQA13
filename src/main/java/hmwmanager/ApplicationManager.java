package hmwmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    HelperSearch search;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public void init(){
        wd = new ChromeDriver();
        logger.info("All tests starts in Chrome browser");
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);
        search = new HelperSearch(wd);

    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HelperSearch getSearch() {
        return search;
    }

    public void stop(){
        wd.quit();
    }

    public CarHelper getCar() {
        return car;
    }
}
