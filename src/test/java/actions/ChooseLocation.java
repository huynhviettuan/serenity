package actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import ui.booking.BookingPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseLocation implements Interaction {

    private String location;

    public ChooseLocation(String location) {
        this.location = location;
    }

    public static Performable at(String location) {
        return instrumented(ChooseLocation.class, location);
    }

    @Override
    @Step("{0} choose #location")
    public <T extends Actor> void performAs(T actor) {
        BookingPage.SEARCH_LOCATION_FIELD.resolveFor(actor).sendKeys(location);
        BookingPage.LOCATION_ITEM.of(location).resolveFor(actor).click();
    }
}
