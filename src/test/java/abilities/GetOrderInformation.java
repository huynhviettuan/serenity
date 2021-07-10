package abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import utilities.PropertiesHelper;

public class GetOrderInformation implements Ability {

    String orderId;
    String phoneNumber;

    public GetOrderInformation(String orderId, String phoneNumber) {
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static GetOrderInformation getOrderFromConfig() {
        return new GetOrderInformation(PropertiesHelper.readProperties("order").getProperty("orderId"),PropertiesHelper.readProperties("order").getProperty("phoneNumber"));
    }

    public static GetOrderInformation as(Actor actor) {
        return actor.abilityTo(GetOrderInformation.class);
    }

}
