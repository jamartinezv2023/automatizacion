package co.edu.udea.calidad.automatizacion.interactions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;

public final class WaitUntil implements Interaction {
    private final long millis;
    public WaitUntil(long millis){ this.millis = millis; }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try { Thread.sleep(millis); } catch (InterruptedException ignored) {}
    }
    public static WaitUntil millis(long m){ return new WaitUntil(m); }
}

