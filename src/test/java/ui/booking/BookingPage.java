package ui.booking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookingPage {
    public static final Target SEARCH_LOCATION_FIELD = Target.the("Search location field").located(By.xpath("//input[@id='ss']"));
    public static final Target LOCATION_ITEM = Target.the("Search location item").locatedBy("//span[@class='search_hl_name'][text()='{0}']");
    public static final Target DATE_FIELD = Target.the("Date field").located(By.xpath("//div[@class='xp__dates-inner']"));
    public static final Target DATE_ITEM = Target.the("Date item").locatedBy("//table//td[@data-date='{0}']");
    public static final Target NUMBER_OF_GUESTS_FIELD = Target.the("Number of guests field").located(By.xpath("//div[@class='xp__input-group xp__guests']"));
    public static final Target INCREASE_ADULTS = Target.the("Increase adults").located(By.xpath("//button[@aria-label='Increase number of Adults']"));
    public static final Target NUMBER_OF_ADULTS = Target.the("Number of adults").located(By.xpath("//input[@id='group_adults']/following-sibling::span[@class='bui-stepper__display']"));
    public static final Target SEARCH_BUTTON = Target.the("Search button").located(By.xpath("//button[@class='sb-searchbox__button ']"));
    public static final Target SEARCH_SUCCESS_MESSAGE = Target.the("Search success mesaage").located(By.xpath("//div[@id='searchresultsTmpl']//h1"));
}
