package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target LOGIN_ICON = Target.the("ícono de login")
            .located(By.id("menuUser"));

    public static final Target LOGIN_BUTTON = Target.the("botón login")
            .located(By.id("sign_in_btn"));

    /** Mensaje de error si las credenciales son incorrectas */
    public static final Target LOGIN_ERROR = Target.the("mensaje de error de login")
            .located(By.xpath("//label[@class='invalid']"));
    public static final Target USERNAME = Target.the("username").located(By.name("username"));
    public static final Target PASSWORD = Target.the("password").located(By.name("password"));
}
