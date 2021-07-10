package tasks.booking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import ui.booking.BookingHomePage;

public class OpenTheApplication implements Task {

    BookingHomePage bookingHomePage;

    @Step("Open the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(bookingHomePage)
        );
    }
}
