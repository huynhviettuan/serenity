package actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import ui.booking.BookingPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectNumberOfAdults implements Interaction {

    private int numberOfAdult;

    public SelectNumberOfAdults(int numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public static Performable value(int numberOfAdult) {
        return instrumented(SelectNumberOfAdults.class, numberOfAdult);
    }

    @Override
    @Step("{0} select #numberOfAdult adults")
    public <T extends Actor> void performAs(T actor) {
        BookingPage.NUMBER_OF_GUESTS_FIELD.resolveFor(actor).click();
        while (numberOfAdult == Integer.parseInt(BookingPage.NUMBER_OF_ADULTS.resolveFor(actor).getText())) {
            BookingPage.INCREASE_ADULTS.resolveFor(actor).click();
        }
    }
}
