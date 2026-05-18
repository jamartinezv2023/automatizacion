package co.edu.udea.calidad.automatizacion.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;

public final class ClickElement implements Interaction {
    private final Target target;
    public ClickElement(Target target){ this.target = target; }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(target));
    }
    public static ClickElement element(Target t){ return new ClickElement(t); }
}

