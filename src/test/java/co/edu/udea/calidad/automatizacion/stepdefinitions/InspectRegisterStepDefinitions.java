package co.edu.udea.calidad.automatizacion.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class InspectRegisterStepDefinitions {

    @Given("that the user opens the register page")
    public void openRegisterPage() {

        OnStage.setTheStage(new OnlineCast());

        OnStage.theActorCalled("Inspector")
                .attemptsTo(
                        Open.url("https://advantageonlineshopping.com/#/register")
                );
    }
}
