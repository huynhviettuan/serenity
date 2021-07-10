package ui.order;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderTrackingPopUp {
    public static final Target ERROR_MESSAGE = Target.the("Order error message").located(By.cssSelector("div.mz-alert-danger"));
    public static final Target CLOSE_BUTTON = Target.the("Order error message").located(By.cssSelector("button.close"));
    public static final Target ORDER_TRACKING = Target.the("Order tracking label").locatedBy("//span[text()='Theo dõi đơn hàng']");
    public static final Target ORDER_ID = Target.the("Order id field").located(By.cssSelector("input[name='orderID']"));
    public static final Target PHONE_NUMBER = Target.the("Phone number field").located(By.cssSelector("input[name='phone']"));
}
