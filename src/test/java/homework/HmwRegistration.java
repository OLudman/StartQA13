package homework;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HmwRegistration extends HmwTestBase {
    @BeforeMethod
    public void preConditionMethod(){
        if ((app.getUserHelper().isLogged())){
            app.getUserHelper().logOut();
        }
    }

    @Test
    public void registrationTestPositive() {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String email = "olgaludman" + i + "@gmail.com";
    String password = "1Ol4ik1Ya";
    app.getUserHelper().openRegistrationForm();
    app.getUserHelper().fillRegistrationForm("Olga", "L", email, password);
    app.getUserHelper().submitCheckBox();
    app.getUserHelper().submitRegistrationForm();

    Assert.assertTrue(app.getUserHelper().isLogged());
    }

}
