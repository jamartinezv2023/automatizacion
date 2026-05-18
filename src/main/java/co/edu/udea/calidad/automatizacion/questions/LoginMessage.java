package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.SIGN_OUT_LABEL;

public class LoginMessage {

    public static Question<String> displayed() {

        return actor ->
                Text.of(SIGN_OUT_LABEL)
                        .answeredBy(actor)
                        .trim();
    }
}
