package co.edu.udea.calidad.automatizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {

    public static final Target USERNAME =
            Target.the("username field")
                    .locatedBy("//input[@name='usernameRegisterPage']");

    public static final Target EMAIL =
            Target.the("email field")
                    .locatedBy("//input[@name='emailRegisterPage']");

    public static final Target PASSWORD =
            Target.the("password field")
                    .locatedBy("//input[@name='passwordRegisterPage']");

    public static final Target CONFIRM_PASSWORD =
            Target.the("confirm password field")
                    .locatedBy("//input[@name='confirm_passwordRegisterPage']");

    public static final Target FIRST_NAME =
            Target.the("first name field")
                    .locatedBy("//input[@name='first_nameRegisterPage']");

    public static final Target LAST_NAME =
            Target.the("last name field")
                    .locatedBy("//input[@name='last_nameRegisterPage']");

    public static final Target PHONE_NUMBER =
            Target.the("phone number field")
                    .locatedBy("//input[@name='phone_numberRegisterPage']");

    public static final Target CITY =
            Target.the("city field")
                    .locatedBy("//input[@name='cityRegisterPage']");

    public static final Target ADDRESS =
            Target.the("address field")
                    .locatedBy("//input[@name='addressRegisterPage']");

    public static final Target STATE =
            Target.the("state field")
                    .locatedBy("//input[@name='state_/_province_/_regionRegisterPage']");

    public static final Target POSTAL_CODE =
            Target.the("postal code field")
                    .locatedBy("//input[@name='postal_codeRegisterPage']");

    public static final Target AGREE_CHECKBOX =
            Target.the("agree checkbox")
                    .locatedBy("//input[@name='i_agree']");

    public static final Target REGISTER_BUTTON =
            Target.the("register button")
                    .locatedBy("//button[@id='register_btn']");

    public static final Target REGISTER_MODAL =
            Target.the("register modal")
                    .locatedBy("//div[contains(@class,'login')]");
}