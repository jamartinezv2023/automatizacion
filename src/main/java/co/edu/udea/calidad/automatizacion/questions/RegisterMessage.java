package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import co.edu.udea.calidad.automatizacion.userinterfaces.RegistrationPage;

public class RegisterMessage implements Question<String> {

    private final boolean isSuccess;

    private RegisterMessage(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public static RegisterMessage success() {
        return new RegisterMessage(true);
    }

    public static RegisterMessage error() {
        return new RegisterMessage(false);
    }

    @Override
    public String answeredBy(Actor actor) {
        try {
            if (isSuccess) {
                return TextContent.of(RegistrationPage.SUCCESS_MESSAGE)
                        .answeredBy(actor)
                        .trim();
            } else {
                return TextContent.of(RegistrationPage.ERROR_MESSAGE)
                        .answeredBy(actor)
                        .trim();
            }
        } catch (Exception e) {
            return "";
        }
    }
}
