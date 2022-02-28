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
                .fuelConsumption("6.4")
                .carRegistrationNumber("I7837WS"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of ")
                .about("Very nice car")
                .build();
        logger.info("car was added" + car.toString());
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto(); // check
        app.getUserHelper().submitLogin(); // fail
        Assert.assertTrue(app.getCar().isCarAdded());
        app.getCar().clickSearch();
    }

    @Test
    public void addNewCarPositive2(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .address("Haifa")
                .make("Mazda")
                .model("3")
                .year("2013")
                .engine("1.4")
                .fuel("Diesel")
                .gear("MT")
                .WD("RWD")
                .doors("3")
                .seats("5")
                .carClass("A")
                .fuelConsumption("6.4")
                .carRegistrationNumber("YUT7676"+i)
                .price("25")
                .distanceIncluded("2000")
                .typeFeature("just any feature")
                .about("My first car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto(); // check
        app.getUserHelper().submitLogin(); // fail
        Assert.assertTrue(app.getCar().isCarAdded());
        app.getCar().clickSearch();
    }

    @Test
    public void addNewCarNegativeByFuelConsumption(){
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
                .fuelConsumption("-6.4")
                .carRegistrationNumber("I7837WS"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of ")
                .about("Very nice car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachPhoto();
        Assert.assertTrue(app.getCar().isErrorOccured());

        Assert.assertTrue(app.getCar().isSubmitButtonDisabled());
//        Assert.assertTrue(app.getCar().isSubmitButtonDisabled2());
        app.getCar().returnToMainPageAfterNegativeTest();
    }

}
