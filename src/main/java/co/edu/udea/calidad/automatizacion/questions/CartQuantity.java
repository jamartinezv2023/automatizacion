package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static co.edu.udea.calidad.automatizacion.userinterfaces.HomePage.CART_QUANTITY;

public class CartQuantity {

    public static Question<Integer> value() {

        return actor ->
                Integer.parseInt(
                        Text.of(CART_QUANTITY)
                                .answeredBy(actor)
                                .trim()
                );
    }
}
