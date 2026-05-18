package co.edu.udea.calidad.automatizacion.stepdefinitions;

import co.edu.udea.calidad.automatizacion.tasks.Login;
import co.edu.udea.calidad.automatizacion.tasks.OpenHome;
import co.edu.udea.calidad.automatizacion.tasks.AddToCart;
import co.edu.udea.calidad.automatizacion.questions.CartDetails;
import io.cucumber.java.en.*;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductCartStepDefinitions {

    @Given("that the customer is logged in")
    public void customerIsLoggedIn() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Cliente").attemptsTo(
                OpenHome.now(), // abrir la home
                Login.withCredentials("nuevoUser7", "Password1*") // login
        );
    }

    @When("he selects one or more products")
    public void selectsProducts() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddToCart.selectProduct("17"), // Producto 1
                AddToCart.selectProduct("18")  // Producto 2
        );
    }

    @When("he adds each product to the cart with different quantities")
    public void addsProductsWithQuantities() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddToCart.withProductAndQuantity("17", 2), // Producto 1 con cantidad 2
                AddToCart.withProductAndQuantity("18", 3)  // Producto 2 con cantidad 3
        );
    }

    @Then("the cart should reflect the selected products with the correct quantities")
    public void verifyCartContents() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(CartDetails.ofProduct("HP Elite x2 1011 G1 Tablet"), equalTo(2)),
                seeThat(CartDetails.ofProduct("HP Pro Tablet 608 G1"), equalTo(3))
        );
    }
}
