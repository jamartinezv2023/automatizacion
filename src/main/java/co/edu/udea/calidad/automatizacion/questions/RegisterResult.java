package co.edu.udea.calidad.automatizacion.questions;

import co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class RegisterResult implements Question<Boolean> {

    public static RegisterResult wasSuccessful() {
        return new RegisterResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        return !RegisterPage.REGISTER_MODAL
                .resolveFor(actor)
                .isVisible();
    }
}