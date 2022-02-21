package hmwmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    HelperSearch search;

    public void init(){
        wd = new ChromeDriver();
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
