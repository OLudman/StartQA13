package homework;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTest extends HmwTestBase{

    @Test
    public void searchPeriodCurrentMonth(){
        app.getSearch().fillSearchFormCurrentMonth("Tel Aviv, Israel", "02/25/2022", "02/28/2022");
        app.getUserHelper().okSubmit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void searchPeriodCurrentMonth2(){
        app.getSearch().fillSearchFormCurrentMonth("Haifa, Israel", "02/25/2022", "02/28/2022");
        app.getUserHelper().okSubmit();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    //homework
    @Test
    public void typePeriodInFuture(){

    }

    @Test
    public void searchPeriodAnyDataInFuture(){
        app.getSearch().fillSearchFormInFuture("Haifa, Israel", "03/30/2022", "06/25/2023");
        app.getUserHelper().submitRegistrationForm();
        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @Test
    public void typePeriodInPast(){

    }

    @AfterMethod
    public void postCondition(){
        app.getSearch().returnHome();
    }
}
