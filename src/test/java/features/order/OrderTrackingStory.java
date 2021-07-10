package features.order;

import abilities.GetOrderInformation;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.order.OrderTrackingMessage;
import tasks.order.OpenHomePage;
import tasks.order.Track;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class OrderTrackingStory {

    Actor tuan = new Actor("tuan");

    @Managed
    WebDriver driver;

    @Steps
    OpenHomePage openHomePage;

    @Before
    public void setup_ability() {
        tuan.can(BrowseTheWeb.with(driver));
        tuan.whoCan(GetOrderInformation.getOrderFromConfig());
    }

    @Test
    public void should_see_error_message_with_wrong_order_information() {
        givenThat(tuan).wasAbleTo(openHomePage);
        when(tuan).attemptsTo(
                Track.withOrderInformation()
        );

        then(tuan).should(
                seeThat(OrderTrackingMessage.getError(), equalTo("Có lỗi xảy ra:\n" +
                        "\n" +
                        "- Mã đơn hàng không hợp lệ"))
        );
    }
}