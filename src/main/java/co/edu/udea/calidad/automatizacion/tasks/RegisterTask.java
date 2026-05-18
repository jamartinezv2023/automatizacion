package co.edu.udea.calidad.automatizacion.tasks;

import co.edu.udea.calidad.automatizacion.models.UserData;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.LOGIN_BUTTON;
import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.CREATE_ACCOUNT;

import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.USERNAME;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.EMAIL;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.PASSWORD;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.CONFIRM_PASSWORD;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.FIRST_NAME;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.LAST_NAME;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.PHONE_NUMBER;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.CITY;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.ADDRESS;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.STATE;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.POSTAL_CODE;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.AGREE_CHECKBOX;
import static co.edu.udea.calidad.automatizacion.userinterfaces.RegisterPage.REGISTER_BUTTON;

public class RegisterTask implements Task {

    private final UserData userData;

    public RegisterTask(UserData userData) {
        this.userData = userData;
    }

    public static RegisterTask withData(UserData userData) {
        return Tasks.instrumented(RegisterTask.class, userData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                WaitUntil.the(LOGIN_BUTTON, isVisible())
                        .forNoMoreThan(20).seconds(),

                WaitUntil.the(LOGIN_BUTTON, isClickable())
                        .forNoMoreThan(20).seconds(),

                Click.on(LOGIN_BUTTON),

                WaitUntil.the(CREATE_ACCOUNT, isVisible())
                        .forNoMoreThan(20).seconds(),

                Click.on(CREATE_ACCOUNT),

                WaitUntil.the(USERNAME, isVisible())
                        .forNoMoreThan(20).seconds(),

                Enter.theValue(userData.getUsername())
                        .into(USERNAME),

                Enter.theValue(userData.getEmail())
                        .into(EMAIL),

                Enter.theValue(userData.getPassword())
                        .into(PASSWORD),

                Enter.theValue(userData.getPassword())
                        .into(CONFIRM_PASSWORD),

                Enter.theValue(userData.getFirstName())
                        .into(FIRST_NAME),

                Enter.theValue(userData.getLastName())
                        .into(LAST_NAME),

                Enter.theValue(userData.getPhoneNumber())
                        .into(PHONE_NUMBER),

                Enter.theValue(userData.getCity())
                        .into(CITY),

                Enter.theValue(userData.getAddress())
                        .into(ADDRESS),

                Enter.theValue(userData.getState())
                        .into(STATE),

                Enter.theValue(userData.getPostalCode())
                        .into(POSTAL_CODE),

                Click.on(AGREE_CHECKBOX),

                Click.on(REGISTER_BUTTON)

        );
    }
}