package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target USERNAME =
            Target.the("login username")
                    .located(By.name("username"));

    public static final Target PASSWORD =
            Target.the("login password")
                    .located(By.name("password"));

    public static final Target LOGIN_BUTTON =
            Target.the("sign in button")
                    .located(By.id("sign_in_btn"));

    public static final Target LOGIN_ERROR =
            Target.the("login error message")
                    .located(By.xpath("//*[contains(text(),'Incorrect user name or password')]"));
}