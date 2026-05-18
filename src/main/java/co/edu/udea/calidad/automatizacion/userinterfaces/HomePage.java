package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    // =========================================================
    // LOGIN
    // =========================================================

    public static final Target USER_ICON =
            Target.the("user menu icon")
                    .located(By.id("menuUser"));

    public static final Target USERNAME =
            Target.the("username input")
                    .located(By.name("username"));

    public static final Target PASSWORD =
            Target.the("password input")
                    .located(By.name("password"));

    public static final Target LOGIN_BUTTON =
            Target.the("login button")
                    .located(By.id("sign_in_btn"));

    public static final Target USERNAME_LABEL =
            Target.the("logged username")
                    .located(By.xpath("//a[@id='menuUserLink']/span"));

    public static final Target LOGIN_ERROR_MESSAGE =
            Target.the("login error message")
                    .located(By.xpath("//label[contains(@class,'invalid')]"));

    // =========================================================
    // CATEGORIES
    // =========================================================

    
    // =========================================================
    // REGISTER
    // =========================================================

    public static final Target CREATE_ACCOUNT =
            Target.the("create account button")
                    .located(By.xpath("//a[contains(@translate,'CREATE_NEW_ACCOUNT')]"));

    // =========================================================
    // CATEGORIES
    // =========================================================

    public static final Target TABLETS_CATEGORY =

            Target.the("tablets category")
                    .located(By.id("tabletsImg"));

    // =========================================================
    // PRODUCTS
    // =========================================================

    public static final Target FIRST_PRODUCT =
            Target.the("first product")
                    .located(By.xpath("(//a[contains(@class,'productName')])[1]"));

    public static final Target ADD_TO_CART =
            Target.the("add to cart")
                    .located(By.name("save_to_cart"));

    public static final Target PLUS_BUTTON =
            Target.the("plus quantity")
                    .located(By.xpath("//div[@class='plus']"));

    public static final Target CART_BUTTON =
            Target.the("cart button")
                    .located(By.id("shoppingCartLink"));

    public static final Target CART_QUANTITY =
            Target.the("cart quantity")
                    .located(By.xpath("//label[contains(@class,'quantity')]"));
}
