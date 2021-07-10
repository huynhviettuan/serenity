package features.calculate;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.calculate.ResultPreview;
import tasks.calculate.Calculate;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class CalculateStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true, driver = "Appium")
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void show_results_of_plus_between_two_number() {
        when(anna).attemptsTo(
                Calculate.with(Calculate.Operations.PLUS).between(5).and(6)
        );

        then(anna).should(
                seeThat(
                        new ResultPreview(), equalTo("11")
                )
        );
    }
}
