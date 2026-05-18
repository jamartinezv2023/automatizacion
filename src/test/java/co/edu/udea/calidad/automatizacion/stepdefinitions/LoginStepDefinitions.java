package co.edu.udea.calidad.automatizacion.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import co.edu.udea.calidad.automatizacion.tasks.Login;
import co.edu.udea.calidad.automatizacion.questions.LoginMessage;

public class LoginStepDefinitions {

    @Before
    public void setStage() {
        // Inicializa Screenplay solo una vez antes de los escenarios
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the customer navigates to the login page")
    public void navigateToLoginPage() {
        // Usamos un actor único para todo el escenario
        OnStage.theActorCalled("Cliente").attemptsTo(
                Login.openLoginPage() // tarea que abre la página principal y modal de login
        );
    }

    @When("he enters valid login credentials")
    public void enterValidCredentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("nuevoUser7", "Password1*")
        );
    }

    @Then("he should be logged into his account successfully")
    public void verifyLoginSuccess() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginMessage.success(), equalTo("Logged in successfully"))
        );
    }

    @When("he enters invalid login credentials")
    public void enterInvalidCredentials() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.withCredentials("invalidUser", "wrongPassword")
        );
    }

    @Then("he should see an error message indicating invalid username or password")
    public void verifyLoginError() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(LoginMessage.error(), equalTo("Invalid username or password"))
        );
    }
}
