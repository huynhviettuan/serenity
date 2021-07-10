package features.login;

import abilities.Authorization;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.login.LoginMessage;
import tasks.login.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class LoginStory {

    Actor user = Actor.named("tuan");

    @Managed
    WebDriver driver;

    @Before
    public void setup_ability() {
        user.can(BrowseTheWeb.with(driver));
        user.whoCan(Authorization.withInformation(user.getName()));
    }

    @Test
    public void should_see_error_message_when_input_wrong_message() {
        user.attemptsTo(
                Login.withUserName(user.abilityTo(Authorization.class).getEmail()).andPassword(user.abilityTo(Authorization.class).getPassword())
        );

        user.should(
                seeThat(LoginMessage.getError(), equalTo("Có lỗi xảy ra:\n- Tài khoản không tồn tại, vui lòng kiểm tra lại"))
        );
    }
}