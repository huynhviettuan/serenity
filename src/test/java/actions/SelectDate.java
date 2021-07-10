package actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import ui.booking.BookingPage;
import utilities.DateHelper;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectDate implements Interaction {

    private String fromDate;
    private String toDate;

    public SelectDate(String fromDate, String toDate) {
        this.fromDate = DateHelper.formatDate(fromDate);
        this.toDate = DateHelper.formatDate(toDate);
    }

    public static class PickADateBuilder {

        private String fromDate;

        public PickADateBuilder(String fromDate) {
            this.fromDate = fromDate;
        }

        public Performable to(String toDate) {
            return instrumented(SelectDate.class, fromDate, toDate);
        }
    }

    public static PickADateBuilder from(String fromDate) {
        return new PickADateBuilder(fromDate);
    }

    @Override
    @Step("{0} select date from #fromDate to #toDate")
    public <T extends Actor> void performAs(T actor) {
        BookingPage.DATE_FIELD.resolveFor(actor).click();
        BookingPage.DATE_FIELD.resolveFor(actor).click();
        BookingPage.DATE_ITEM.of(fromDate).resolveFor(actor).click();
        BookingPage.DATE_ITEM.of(toDate).resolveFor(actor).click();
    }
}
