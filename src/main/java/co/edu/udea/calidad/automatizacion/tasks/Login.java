package co.edu.udea.calidad.automatizacion.tasks;

import co.edu.udea.calidad.automatizacion.models.User;
import co.edu.udea.calidad.automatizacion.userinterfaces.HomePage;
import co.edu.udea.calidad.automatizacion.userinterfaces.LoginPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final User user;

    public Login(User user) {
        this.user = user;
    }

    public static Login withCredentials(String username, String password) {
        return Instrumented.instanceOf(Login.class)
                .withProperties(new User(username, password));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(HomePage.USER_ICON, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(HomePage.USER_ICON),

                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(user.username()).into(LoginPage.USERNAME),

                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(15).seconds(),
                Enter.theValue(user.password()).into(LoginPage.PASSWORD),

                WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}