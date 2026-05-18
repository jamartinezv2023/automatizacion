package co.edu.udea.calidad.automatizacion.questions;

import co.edu.udea.calidad.automatizacion.userinterfaces.CartPage;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartDetails implements Question<Integer> {

    private final String productName;

    public CartDetails(String productName) {
        this.productName = productName;
    }

    public static CartDetails ofProduct(String productName) {
        return new CartDetails(productName);
    }

    @Override
    public Integer answeredBy(Actor actor) {
        // Obtener todos los productos en el carrito
        ListOfWebElementFacades items = CartPage.CART_ITEMS.resolveAllFor(actor);

        for (WebElement item : items) {
            String name = item.findElement(By.cssSelector(".productName")).getText();
            if (name.equalsIgnoreCase(productName)) {
                String qtyText = item.findElement(By.cssSelector(".quantity")).getAttribute("value");
                return Integer.parseInt(qtyText);
            }
        }
        return 0; // Si no encuentra el producto
    }
}
