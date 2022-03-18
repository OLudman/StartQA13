package hmwmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
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
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init(){
        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }
        logger.info("All tests starts in browser " + browser);
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
