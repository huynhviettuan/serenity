package ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target ERROR_MESSAGE = Target.the("Login error message").locatedBy("div .-alert-danger");
    public static final Target EMAIL = Target.the("Login email field").locatedBy("#auth-block__form-group__email");
    public static final Target PASSWORD = Target.the("Login password field").located(By.cssSelector("input[name='password']"));
}
