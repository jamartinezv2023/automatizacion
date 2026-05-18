package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage {
    public static final Target CART_ITEMS = Target.the("cart items").located(By.cssSelector(".cartItem"));
    public static final Target ITEM_NAME = Target.the("item name").located(By.cssSelector(".cartItem .productName"));
    public static final Target ITEM_QUANTITY = Target.the("item quantity").located(By.cssSelector(".quantity"));
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button").located(By.id("checkOutButton"));
    public static final Target TOTAL = Target.the("cart total").located(By.cssSelector(".totalPrice"));
}
