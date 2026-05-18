package co.edu.udea.calidad.automatizacion.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectProduct implements Task {
    private final String name;

    public SelectProduct(String name){ this.name = name; }

    public static SelectProduct called(String name){ return new SelectProduct(name); }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target product = Target.the("product " + name)
                .located(By.xpath("//a[contains(@class,'productName') and normalize-space()='" + name + "']"));
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Click.on(product));
    }
}

