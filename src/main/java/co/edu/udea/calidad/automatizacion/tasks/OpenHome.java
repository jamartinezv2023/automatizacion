package co.edu.udea.calidad.automatizacion.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

public class OpenHome implements Task {

    private final String url;

    // Constructor privado
    private OpenHome(String url) {
        this.url = url;
    }

    /** Abrir la URL específica */
    public static OpenHome url(String url) {
        return new OpenHome(url);
    }

    /** Abrir la página por defecto */
    public static OpenHome now() {
        return new OpenHome("https://www.advantageonlineshopping.com");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
