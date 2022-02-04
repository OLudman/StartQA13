package homework;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HmwIlCarroLogin extends HmwTestBase {

    @BeforeMethod
    public void preConditionMethod(){
        if ((app.getUserHelper().isLogged())){
            app.getUserHelper().logOut();
        }
    }

    @Test
    public void LoginPositiveTest(){
        User user = new User().withEmail("olgaludman@gmail.com").withPassword("Ol4ik1Ya");
        app.getUserHelper().openLoginForm();
//        app.getUserHelper().fillLoginForm("olgaludman@gmail.com", "Ol4ik1Ya");
        app.getUserHelper().submitLogin();

        Assert.assertTrue(app.getUserHelper().isLogged());
    }

    @Test
    public void loginPositiveTest2(){
        String email = "olgaludman@gmail.com";
        String password = "Ol4ik1Ya";

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitLogin();
        Assert.assertTrue(app.getUserHelper().isLogged());
    }

    @Test
    public void loginNegativeTest(){
        String email = "olgaludman@gmail.com";
        String password = "1Ol4ik1Ya";

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email, password);
        app.getUserHelper().submitLogin();

        Assert.assertFalse(app.getUserHelper().isLogged());
    }

    @AfterMethod
    public void pastConditionMethod(){
        app.getUserHelper().okSubmit();
    }

}
