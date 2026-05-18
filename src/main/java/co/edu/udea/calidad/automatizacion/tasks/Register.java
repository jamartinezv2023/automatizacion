package co.edu.udea.calidad.automatizacion.tasks;

import co.edu.udea.calidad.automatizacion.models.User;
import co.edu.udea.calidad.automatizacion.userinterfaces.HomePage;
import co.edu.udea.calidad.automatizacion.userinterfaces.RegistrationPage;
import co.edu.udea.calidad.automatizacion.interactions.ClickElement;
import co.edu.udea.calidad.automatizacion.interactions.EnterText;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.MoveMouse;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Register implements Task {

    private final User user;

    public Register(User user) {
        this.user = user;
    }

    /** Abrir página principal */
    public static Task openHomePage() {
        return Task.where("{0} abre la página principal",
                Open.url("https://advantageonlineshopping.com/"));
    }

    /** Crear usuario con los datos obligatorios */
    public static Task withData(String username, String email, String password, boolean agreeTerms) {
        User newUser = new User(username, password, email, agreeTerms);
        return Instrumented.instanceOf(Register.class).withProperties(newUser);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Abrir modal de login
                WaitUntil.the(HomePage.USER_ICON, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(HomePage.USER_ICON, isClickable()).forNoMoreThan(15).seconds(),
                MoveMouse.to(HomePage.USER_ICON),
                ClickElement.element(HomePage.USER_ICON),

                // Click en "CREATE NEW ACCOUNT"
                WaitUntil.the(HomePage.CREATE_ACCOUNT, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(HomePage.CREATE_ACCOUNT),

                // Llenar campos obligatorios
                WaitUntil.the(RegistrationPage.USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                EnterText.into(RegistrationPage.USERNAME, user.username()),
                EnterText.into(RegistrationPage.EMAIL, user.email()),
                EnterText.into(RegistrationPage.PASSWORD, user.password()),
                EnterText.into(RegistrationPage.REPEAT_PASSWORD, user.password()),

                // Checkbox "I agree" (hacemos click en el label)
                WaitUntil.the(RegistrationPage.AGREE_TERMS_LABEL, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(RegistrationPage.AGREE_TERMS_LABEL),

                // Enviar formulario
                WaitUntil.the(RegistrationPage.REGISTER_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(RegistrationPage.REGISTER_BUTTON),

                // Esperar que aparezca algún mensaje (éxito o error)
                WaitUntil.the(RegistrationPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(15).seconds()
        );
    }


    /** Fábrica oficial de Screenplay */
    public static Register with(User user) {
        return Instrumented.instanceOf(Register.class).withProperties(user);
    }
}
