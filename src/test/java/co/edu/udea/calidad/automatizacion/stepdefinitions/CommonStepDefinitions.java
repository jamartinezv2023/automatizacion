package co.edu.udea.calidad.automatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CommonStepDefinitions {

    @Before
    public void setupActor() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the customer navigates to the login page")
    public void navigateToLoginPage() {

        OnStage.theActorCalled("Cliente")
                .attemptsTo(
                        co.edu.udea.calidad.automatizacion.tasks.OpenTask.browser()
                );
    }
}
