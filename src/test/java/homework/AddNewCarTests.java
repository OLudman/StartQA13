package homework;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends HmwTestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getUserHelper().isLogged()){
            app.getUserHelper().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345@"));
            app.getUserHelper().pause(5000);
        }
    }

    @Test
    public void addNewCarPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("AT")
                .WD("AWD")
                .doors("5")
                .seats("4")
                .carClass("C")
                .fuel("Petrol")
                .fuelConsumption("6.4")
                .carRegistrationNumber("I7837WS"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of ")
                .about("Very nice car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto();
        app.getUserHelper().submitLogin();
        Assert.assertTrue(app.getCar().isCarAdded());
        app.getCar().clickSearch();
    }

    // testPositive2 -add one new car
    // testNegativeByPass

}
