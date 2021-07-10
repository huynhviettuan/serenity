package tasks.booking;

import actions.SelectNumberOfAdults;
import actions.ChooseLocation;
import actions.SelectDate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.booking.BookingPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Booking implements Task {

    private String location;
    private String fromDate;
    private String toDate;
    private int numberOfAdults;

    public Booking(String location, String fromDate, String toDate, int numberOfAdults) {
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.numberOfAdults = numberOfAdults;
    }

    public static class BookingBuilder {

        private String location;
        private String fromDate;
        private String toDate;

        public BookingBuilder withLocation(String location) {
            this.location = location;
            return this;
        }

        public BookingBuilder from(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }

        public BookingBuilder to(String toDate) {
            this.toDate = toDate;
            return this;
        }

        public Performable withNumberOfAdults(int numberOfAdults) {
            return instrumented(Booking.class, location, fromDate, toDate, numberOfAdults);
        }
    }

    public static BookingBuilder aTicket() {
        return new BookingBuilder();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ChooseLocation.at(location),
                SelectDate.from(fromDate).to(toDate),
                SelectNumberOfAdults.value(numberOfAdults),
                Click.on(BookingPage.SEARCH_BUTTON)
        );
    }
}
