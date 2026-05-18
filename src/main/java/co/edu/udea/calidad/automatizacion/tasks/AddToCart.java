package co.edu.udea.calidad.automatizacion.tasks;

import co.edu.udea.calidad.automatizacion.interactions.ClickElement;
import co.edu.udea.calidad.automatizacion.interactions.EnterText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddToCart implements Task {

    private final String productId;

    public AddToCart(String productId) {
        this.productId = productId;
    }

    /** Selecciona un producto */
    public static AddToCart selectProduct(String productId) {
        return Instrumented.instanceOf(AddToCart.class).withProperties(productId);
    }

    /** Agrega un producto con cantidad */
    public static Task withProductAndQuantity(String productId, int quantity) {
        return Instrumented.instanceOf(AddToCartWithQuantity.class)
                .withProperties(productId, quantity);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Categoría Tablets
        Target TABLETS_IMG = Target.the("tablets category")
                .located(By.id("tabletsImg"));

        // Botón SHOP NOW del producto usando XPath
        Target PRODUCT_BUTTON = Target.the("Shop Now button for product " + productId)
                .located(By.xpath("//li[.//img[@id='" + productId + "']]//div[contains(@class,'AddToCard')]"));

        actor.attemptsTo(
                WaitUntil.the(TABLETS_IMG, isClickable()).forNoMoreThan(10).seconds(),
                ClickElement.element(TABLETS_IMG),

                WaitUntil.the(PRODUCT_BUTTON, isClickable()).forNoMoreThan(10).seconds(),
                Scroll.to(PRODUCT_BUTTON),
                ClickElement.element(PRODUCT_BUTTON)
        );
    }

    /** Clase interna para agregar cantidad y guardar en carrito */
    public static class AddToCartWithQuantity implements Task {

        private final String productId;
        private final int quantity;

        public AddToCartWithQuantity(String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {

            Target QUANTITY_INPUT = Target.the("quantity input")
                    .located(By.name("quantity"));
            Target SAVE_BUTTON = Target.the("save to cart button")
                    .located(By.name("save_to_cart"));

            // Selecciona el producto primero
            actor.attemptsTo(AddToCart.selectProduct(productId));

            // Cambiar cantidad y guardar
            actor.attemptsTo(
                    WaitUntil.the(QUANTITY_INPUT, isClickable()).forNoMoreThan(5).seconds(),
                    EnterText.into(QUANTITY_INPUT, String.valueOf(quantity)),

                    WaitUntil.the(SAVE_BUTTON, isClickable()).forNoMoreThan(5).seconds(),
                    ClickElement.element(SAVE_BUTTON)
            );
        }
    }
}
