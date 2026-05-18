package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import co.edu.udea.calidad.automatizacion.userinterfaces.HomePage;

public class LoginMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        try {
            return Text.of(HomePage.HOME_TITLE)
                    .answeredBy(actor)
                    .trim();
        } catch (Exception e) {
            return "";
        }
    }

    public static LoginMessage value() {
        return new LoginMessage();
    }

    // =====================================================
    // ✔ MÉTODO PARA MENSAJE DE LOGIN EXITOSO
    // =====================================================
    public static Question<String> success() {
        return actor -> {
            try {
                return Text.of(HomePage.HOME_TITLE)
                        .answeredBy(actor)
                        .trim();
            } catch (Exception e) {
                return "";
            }
        };
    }

    // =====================================================
    // ✔ MÉTODO PARA MENSAJE DE LOGIN FALLIDO
    // =====================================================
    public static Question<String> error() {
        return actor -> {
            try {
                return Text.of(HomePage.ERROR_MESSAGE)
                        .answeredBy(actor)
                        .trim();
            } catch (Exception e) {
                return "";
            }
        };
    }
}
