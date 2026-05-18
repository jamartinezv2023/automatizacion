package co.edu.udea.calidad.automatizacion.stepdefinitions;

import co.edu.udea.calidad.automatizacion.questions.CartQuantity;
import co.edu.udea.calidad.automatizacion.tasks.AddToCart;
import co.edu.udea.calidad.automatizacion.tasks.Login;
import co.edu.udea.calidad.automatizacion.tasks.OpenTask;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class ProductCartStepDefinitions {

    @Given("that the customer is logged in")
    public void customerLoggedIn() {

        theActorCalled("Cliente").attemptsTo(
                OpenTask.browser(),
                Login.withCredentials("nuevoUser7", "Password1*")
        );
    }

    @When("he selects one or more products")
    public void selectsProducts() {

        theActorInTheSpotlight().attemptsTo(
                AddToCart.withQuantity(2)
        );
    }

    @When("he adds each product to the cart with different quantities")
    public void addProductsWithQuantities() {

        theActorInTheSpotlight().attemptsTo(
                AddToCart.withQuantity(3)
        );
    }

    @Then("the cart should reflect the selected products with the correct quantities")
    public void verifyCartContents() {

        theActorInTheSpotlight().should(
                seeThat(CartQuantity.value(), equalTo(3))
        );
    }
}
