package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.USERNAME_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginMessage {

    public static Question<String> displayed() {

        return actor -> {

            actor.attemptsTo(
                    WaitUntil.the(USERNAME_LABEL, isVisible())
                            .forNoMoreThan(20)
                            .seconds()
            );

            return Text.of(USERNAME_LABEL)
                    .answeredBy(actor)
                    .trim();
        };
    }
}
