package hmwmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchFormCurrentMonth(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMonth(dateFrom, dateTo);
    }

    public void selectPeriodCurrentMonth(String dateFrom, String dateTo) {
        click(By.id("dates"));
        String[]dataF = dateFrom.split("/");
        String[] dataT =dateTo.split("/");
        String locator = "//div[text()=' "+ dataF[1]+ " ']";
        click((By.xpath(locator)));
        String loc = String.format("//div[text()=' %s ']", dataT[1]);
        click(By.xpath(loc));

//        click(By.xpath("//div[text()=' 25 ']"));
//        click(By.xpath("//div[text()=' 28 ']"));
        pause(5000);
    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        wd.findElement(By.cssSelector(".pac-item"));
        pause(500);
    }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnHome() {
        click(By.cssSelector(".header a[href='/']"));
    }
}
