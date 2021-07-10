package tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.login.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private String username;
    private String password;

    public Login(String _username, String _password) {
        this.username = _username;
        this.password = _password;
    }

    public static class LoginBuilder {
        private String username;

        public LoginBuilder(String username) {
            this.username = username;
        }

        public Login andPassword(String password) {
            return instrumented(Login.class, this.username, password);
        }
    }

    public static LoginBuilder withUserName(String userName) {
        return new LoginBuilder(userName);
    }

    @Override
    @Step("{0} login with credential #username and # password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://fado.vn/dang-nhap"),
                Enter.theValue(this.username).into(LoginPage.EMAIL),
                Enter.theValue(this.password).into(LoginPage.PASSWORD).thenHit(Keys.ENTER)

        );
    }
}
