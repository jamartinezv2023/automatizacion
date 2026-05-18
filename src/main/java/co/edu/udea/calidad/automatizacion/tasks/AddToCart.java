package co.edu.udea.calidad.automatizacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {

    private final Integer quantity;

    public AddToCart(Integer quantity) {
        this.quantity = quantity;
    }

    public static AddToCart withQuantity(Integer quantity) {
        return Tasks.instrumented(AddToCart.class, quantity);
    }

    public static AddToCart selectProduct(String productId) {
        return Tasks.instrumented(AddToCart.class, 1);
    }

    public static AddToCart withProductAndQuantity(String productId, Integer quantity) {
        return Tasks.instrumented(AddToCart.class, quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Scroll.to(TABLETS_CATEGORY),

                WaitUntil.the(TABLETS_CATEGORY, isClickable())
                        .forNoMoreThan(20)
                        .seconds(),

                JavaScriptClick.on(TABLETS_CATEGORY),

                WaitUntil.the(FIRST_PRODUCT, isVisible())
                        .forNoMoreThan(20)
                        .seconds(),

                Click.on(FIRST_PRODUCT),

                WaitUntil.the(ADD_TO_CART, isClickable())
                        .forNoMoreThan(20)
                        .seconds()
        );

        for (int i = 1; i < quantity; i++) {

            actor.attemptsTo(
                    Click.on(PLUS_BUTTON)
            );
        }

        actor.attemptsTo(
                Click.on(ADD_TO_CART)
        );
    }
}
