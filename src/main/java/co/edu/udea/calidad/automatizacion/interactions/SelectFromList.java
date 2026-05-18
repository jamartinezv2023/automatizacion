package co.edu.udea.calidad.automatizacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.support.ui.Select;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectFromList implements Interaction {

    private final Target target;
    private final String value;

    public SelectFromList(Target target, String value) {
        this.target = target;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Para listas <select>
            new Select(target.resolveFor(actor)).selectByVisibleText(value);
        } catch (Exception e) {
            // Para listas tipo dropdown personalizadas
            target.resolveFor(actor).click();
            target.resolveFor(actor)
                    .findBy("//li[contains(text(),'" + value + "')]")
                    .click();
        }
    }

    public static SelectFromList option(Target target, String value) {
        return instrumented(SelectFromList.class, target, value);
    }
}
