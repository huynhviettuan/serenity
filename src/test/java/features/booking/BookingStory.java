package features.booking;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.booking.BookingMessage;
import tasks.booking.Booking;
import tasks.booking.OpenTheApplication;

import javax.annotation.PostConstruct;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class BookingStory {

    @Managed
    WebDriver driver;

    Actor actor = Actor.named("tuan");

    @Steps
    OpenTheApplication openTheApplication;

    @Before
    public void setupAbility() {
        actor.can(BrowseTheWeb.with(driver));
    }

    @Test
    public void user_should_see_ticket_information_after_booking_successfully() {
        givenThat(actor).wasAbleTo(openTheApplication);
        when(actor).attemptsTo(
                Booking.aTicket().withLocation("Danang").from("14/06/2021").to("14/07/2021").withNumberOfAdults(2)
        );
        then(actor).should(
                seeThat(BookingMessage.getSuccessMessage(), equalTo("Da Nang: 808 properties found"))
        );
    }
}
