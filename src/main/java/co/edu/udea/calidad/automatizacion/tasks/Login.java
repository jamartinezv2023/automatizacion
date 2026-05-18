package co.edu.udea.calidad.automatizacion.tasks;

import co.edu.udea.calidad.automatizacion.models.User;
import co.edu.udea.calidad.automatizacion.userinterfaces.LoginPage;
import co.edu.udea.calidad.automatizacion.userinterfaces.HomePage;
import co.edu.udea.calidad.automatizacion.interactions.ClickElement;
import co.edu.udea.calidad.automatizacion.interactions.EnterText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final User user;

    public Login(User user) {
        this.user = user;
    }

    public static Task openLoginPage() {
        return Task.where("{0} abre la página de login",
                Open.url("https://advantageonlineshopping.com/"));
    }

    /** Fábrica para login con credenciales */
    public static Login withCredentials(String username, String password){
        return Instrumented.instanceOf(Login.class)
                .withProperties(new User(username, password));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Abrir modal de login desde homepage si no navegamos directo
                WaitUntil.the(HomePage.USER_ICON, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(HomePage.USER_ICON),

                // Esperar que los campos estén visibles y llenarlos
                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                EnterText.into(LoginPage.USERNAME, user.username()),

                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(10).seconds(),
                EnterText.into(LoginPage.PASSWORD, user.password()),

                // Click en login
                WaitUntil.the(LoginPage.LOGIN_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(LoginPage.LOGIN_BUTTON)
        );
    }
}
