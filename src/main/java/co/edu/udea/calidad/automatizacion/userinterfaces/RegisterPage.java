package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage {

    // =========================================================
    // ACCOUNT DETAILS
    // =========================================================

    public static final Target USERNAME =
            Target.the("username field")
                    .located(By.name("usernameRegisterPage"));

    public static final Target EMAIL =
            Target.the("email field")
                    .located(By.name("emailRegisterPage"));

    public static final Target PASSWORD =
            Target.the("password field")
                    .located(By.name("passwordRegisterPage"));

    public static final Target CONFIRM_PASSWORD =
            Target.the("confirm password field")
                    .located(By.name("confirm_passwordRegisterPage"));

    // =========================================================
    // PERSONAL DETAILS
    // =========================================================

    public static final Target FIRST_NAME =
            Target.the("first name field")
                    .located(By.name("first_nameRegisterPage"));

    public static final Target LAST_NAME =
            Target.the("last name field")
                    .located(By.name("last_nameRegisterPage"));

    public static final Target PHONE_NUMBER =
            Target.the("phone number field")
                    .located(By.name("phone_numberRegisterPage"));

    // =========================================================
    // ADDRESS
    // =========================================================

    public static final Target CITY =
            Target.the("city field")
                    .located(By.name("cityRegisterPage"));

    public static final Target ADDRESS =
            Target.the("address field")
                    .located(By.name("addressRegisterPage"));

    public static final Target STATE =
            Target.the("state field")
                    .located(By.name("state_/_province_/_regionRegisterPage"));

    public static final Target POSTAL_CODE =
            Target.the("postal code field")
                    .located(By.name("postal_codeRegisterPage"));

    // =========================================================
    // AGREEMENT
    // =========================================================

    public static final Target AGREE_CHECKBOX =
            Target.the("agree checkbox")
                    .located(By.name("i_agree"));

    // =========================================================
    // REGISTER BUTTON
    // =========================================================

    public static final Target REGISTER_BUTTON =
            Target.the("register button")
                    .located(By.id("register_btn"));
}
