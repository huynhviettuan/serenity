package abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import utilities.PropertiesHelper;

public class Authorization implements Ability {

    String email;
    String password;

    public Authorization(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static Authorization withInformation(String name) {
        return new Authorization(PropertiesHelper.readProperties(name).getProperty("email"),PropertiesHelper.readProperties(name).getProperty("password"));
    }

    public static Authorization as(Actor actor) {
        return actor.abilityTo(Authorization.class);
    }
}