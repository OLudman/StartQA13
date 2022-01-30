package hmwmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//*[text()='Log in']")); //   click(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"), email);
        type(By.id("password"),password);
    }

    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
    }

    public void okSubmit(){
        click(By.xpath("//button[text()='Ok']"));
    }

    public void openRegistrationForm(){
        click(By.xpath("//a[text()='Log in']"));
        click(By.xpath("//*[text()='Click here']"));
    }

    public void fillRegistrationForm(String name, String lastName, String email, String password){
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void submitRegistrationForm(){
        click(By.cssSelector("button[type='submit']"));
    }

    public void submitCheckBox(){
        WebElement label = wd.findElement(By.xpath("//label[@for = 'terms-of-use']"));
        Rectangle rectangle = label.getRect();
        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().build().perform();
        int offSetX = rectangle.getWidth()/2;
        int offSetY = rectangle.getHeight()/2;
        actions.moveByOffset(-offSetX, -offSetY).click().release().build().perform();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[contains(.,'Delete account')]"));
    }

    public void logOut() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }
}
