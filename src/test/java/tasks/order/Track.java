package tasks.order;

import abilities.GetOrderInformation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import ui.order.OrderTrackingPopUp;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Track implements Task {

    public static Performable withOrderInformation() {
         return instrumented(Track.class);
    }

    private GetOrderInformation orderInformation (Actor actor) {
        return GetOrderInformation.as(actor);
    }

    @Override
    @Step("{0} track the order with order information")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OrderTrackingPopUp.CLOSE_BUTTON),
                Click.on(OrderTrackingPopUp.ORDER_TRACKING),
                Enter.theValue(orderInformation(actor).getOrderId()).into(OrderTrackingPopUp.ORDER_ID),
                Enter.theValue(orderInformation(actor).getPhoneNumber()).into(OrderTrackingPopUp.PHONE_NUMBER).thenHit(Keys.ENTER)
        );
    }
}