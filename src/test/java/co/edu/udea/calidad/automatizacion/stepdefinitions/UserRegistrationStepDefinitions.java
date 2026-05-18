package co.edu.udea.calidad.automatizacion.stepdefinitions;

import co.edu.udea.calidad.automatizacion.models.UserData;
import co.edu.udea.calidad.automatizacion.questions.RegisterResult;
import co.edu.udea.calidad.automatizacion.tasks.OpenTask;
import co.edu.udea.calidad.automatizacion.tasks.RegisterTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class UserRegistrationStepDefinitions {

    @Given("that the user opens the home page of the store")
    public void openHomePage() {

        theActorCalled("Jose")
                .attemptsTo(
                        OpenTask.browser()
                );
    }

    @When("he interacts with the registration form entering the corresponding data")
    public void fillRegistrationForm(DataTable dataTable) {

        List<Map<String, String>> data =
                dataTable.asMaps(String.class, String.class);

        Map<String, String> userMap = data.get(0);

        String uniqueValue =
                String.valueOf(System.currentTimeMillis());

        String dynamicUsername =
                userMap.get("username") + uniqueValue;

        String dynamicEmail =
                uniqueValue + userMap.get("email");

        UserData userData = new UserData();

        userData.setUsername(dynamicUsername);
        userData.setEmail(dynamicEmail);
        userData.setPassword(userMap.get("password"));
        userData.setFirstName(userMap.get("firstName"));
        userData.setLastName(userMap.get("lastName"));
        userData.setPhoneNumber(userMap.get("phoneNumber"));
        userData.setCity(userMap.get("city"));
        userData.setAddress(userMap.get("address"));
        userData.setState(userMap.get("state"));
        userData.setPostalCode(userMap.get("postalCode"));

        theActorInTheSpotlight()
                .attemptsTo(
                        RegisterTask.withData(userData)
                );
    }

    @Then("the system should validate the successful creation of the profile on the platform")
    public void validateSuccessfulRegistration() {

        theActorInTheSpotlight().should(
                seeThat(
                        RegisterResult.wasSuccessful()
                )
        );
    }
}