package questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.login.LoginPage;

public class LoginMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.ERROR_MESSAGE.resolveFor(actor).getText();
    }

    public static Question<String> getError() {
        return new LoginMessage();
    }
}
