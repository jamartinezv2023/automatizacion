package co.edu.udea.calidad.automatizacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenTask implements Task {

    private static final String URL =
            "https://www.advantageonlineshopping.com";

    public static OpenTask browser() {
        return Tasks.instrumented(OpenTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url(URL)
        );
    }
}
