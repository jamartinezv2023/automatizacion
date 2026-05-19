package co.edu.udea.calidad.automatizacion.stepdefinitions;

import co.edu.udea.calidad.automatizacion.tasks.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.edu.udea.calidad.automatizacion.questions.LoginMessage;

public class LoginStepDefinitions {

    @When("he enters invalid login credentials")
    public void invalidLogin() {

        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("invalidUser", "wrongPassword")
        );
    }

    @Then("he should see an error message indicating invalid username or password")
    public void verifyLoginError() {

        theActorInTheSpotlight().should(
                seeThat(
                        LoginMessage.displayed(),
                        containsString("Incorrect user name or password")
                )
        );
    }
}