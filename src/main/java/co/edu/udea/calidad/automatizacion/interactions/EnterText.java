package co.edu.udea.calidad.automatizacion.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Actor;

public final class EnterText implements Interaction {
    private final Target target;
    private final String value;

    public EnterText(Target target, String value){
        this.target = target; this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(value).into(target));
    }

    public static EnterText into(Target target, String value){
        return new EnterText(target, value);
    }
}

