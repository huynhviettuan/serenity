package questions.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import ui.order.OrderTrackingPopUp;

public class OrderTrackingMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return OrderTrackingPopUp.ERROR_MESSAGE.resolveFor(actor).getText();
    }

    public static OrderTrackingMessage getError() {
        return new OrderTrackingMessage();
    }
}