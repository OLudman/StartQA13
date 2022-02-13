package hmwmanager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static javafx.beans.binding.Bindings.select;

public class CarHelper extends HelperBase{
    public boolean isErrorOccured(){
        return isElementPresent(By.cssSelector(".error"));
    };

    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
        if(isCarCreationFormPresent()){
            typeLocation(car.getAddress());
            type(By.id("make"), car.getMake());
            type(By.id("model"), car.getModel());
            type(By.id("year"), car.getYear());
            type(By.id("engine"), car.getEngine());

            select(By.id("fuel"), car.getFuel());
            select(By.id("gear"), car.getGear());
            select(By.id("wheelsDrive"), car.getWD());

            type(By.id("door"), car.getDoors());
            type(By.id("seats"), car.getSeats());
            type(By.id("class"), car.getCarClass());
            type(By.id("fuelConsumption"), car.getFuelConsumption());
            type(By.id("serialNumber"), car.getCarRegistrationNumber());
            type(By.id("price"),car.getPrice());
            type(By.id("distance"), car.getDistanceIncluded());
            type(By.cssSelector(".feature-input"), car.getTypeFeature());
            type(By.id("about"),car.getAbout());

        }

    }

    public void select(By locator, String option){
//        new Select(wd.findElement(locator)).selectByIndex(2);
        new Select(wd.findElement(locator)).selectByValue(option);
//        new Select(wd.findElement(locator)).selectByVisibleText("Pertol");
    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    private boolean isCarCreationFormPresent() {
        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "Write some details about your car to rent it out"));
        return isForm;
    }

    public void attachPhoto() {
        wd.findElement(By.id("photos")).sendKeys("C:\\Users\\vanan\\Desktop\\qa telran myproject\\StartQA13\\BMW.jpg");
    }

    public boolean isCarAdded() {
        //pause(2000);
        new WebDriverWait(wd,10).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container h1")).getText().equals("Car added");
    }

    public void clickSearch() {
        click(By.xpath("//button[text()='Search cars']"));
    }
}
