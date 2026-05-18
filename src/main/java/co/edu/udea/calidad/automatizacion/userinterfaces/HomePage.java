package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class HomePage {

    public static final Target LOGIN_BUTTON =
            Target.the("login button")
                    .located(By.id("menuUserLink"));

    public static final Target USER_ICON =
            Target.the("user icon")
                    .located(By.id("menuUserLink"));

    public static final Target USER_LABEL =
            Target.the("logged user label")
                    .located(By.xpath("//span[contains(@class,'hi-user')]"));

    public static final Target USERNAME =
            Target.the("username")
                    .located(By.name("username"));

    public static final Target PASSWORD =
            Target.the("password")
                    .located(By.name("password"));

    public static final Target CREATE_ACCOUNT =
            Target.the("create account option")
                    .located(By.xpath("//a[contains(normalize-space(),'CREATE NEW ACCOUNT')]"));

    public static final Target SIGN_OUT_LABEL =
            Target.the("sign out label")
                    .located(By.xpath("//*[contains(normalize-space(),'Sign out')]"));

    public static final Target TABLETS_CATEGORY =
            Target.the("tablets category")
                    .located(By.xpath("//span[contains(normalize-space(),'TABLETS')]"));

    public static final Target FIRST_PRODUCT =
            Target.the("first product")
                    .located(By.xpath("(//a[contains(@class,'productName')])[1]"));

    public static final Target ADD_TO_CART =
            Target.the("add to cart button")
                    .located(By.name("save_to_cart"));

    public static final Target PLUS_BUTTON =
            Target.the("plus quantity button")
                    .located(By.xpath("//div[contains(@class,'plus')]"));

    public static final Target CART_QUANTITY =
            Target.the("cart quantity")
                    .located(By.xpath("//*[contains(@class,'cart')]"));
}