package questions.booking;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.booking.BookingPage;

public class BookingMessage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return BookingPage.SEARCH_SUCCESS_MESSAGE.resolveFor(actor).waitUntilVisible().getText();
    }

    public static BookingMessage getSuccessMessage() {
        return new BookingMessage();
    }
}