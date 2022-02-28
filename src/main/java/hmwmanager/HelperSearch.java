package hmwmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        wd.findElement(By.cssSelector("pac-item"));
        pause(500);
    }


    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void returnHome() {
        click(By.cssSelector(".header a[href='/']"));
    }

    public void fillSearchFormInFuture(String city, String from, String to) {
        fillInputCity(city);
        selectAnyData(from,to);
    }

    private void selectAnyData(String dataFrom, String dataTo) {
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/DD/YYYY"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/DD/YYYY"));
        LocalDate now = LocalDate.now();
        click(By.id("dates"));
        int monthDiff = from.getYear()-now.getYear()
                ==0? from.getMonthValue()-now.getMonthValue() : 12-now.getMonthValue()+ from.getMonthValue();
        clickNextMonth(monthDiff);
        String dataLocator = String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dataLocator));
        monthDiff = to.getYear() - from.getYear()
                ==0? to.getMonthValue() - from.getMonthValue() :12-from.getMonthValue()+to.getMonthValue();
        clickNextMonth(monthDiff);
        dataLocator=String.format("//div[text()=' %s ']", from.getDayOfMonth());
        click(By.xpath(dataLocator));
    }

    private void clickNextMonth(int count){
        for(int i=0; i<count; i++){
            click(By.cssSelector("button[aria-label='Next month']"));
        }
    }
}
