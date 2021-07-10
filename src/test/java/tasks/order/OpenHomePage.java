package tasks.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import ui.order.FadoHomePage;

public class OpenHomePage implements Task {

    FadoHomePage fadoHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(fadoHomePage)
        );
    }

}
