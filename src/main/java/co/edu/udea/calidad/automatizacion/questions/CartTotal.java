package co.edu.udea.calidad.automatizacion.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.questions.Text;
import co.edu.udea.calidad.automatizacion.userinterfaces.CartPage;

public class CartTotal implements Question<Double> {

    @Override
    public Double answeredBy(Actor actor) {
        try {
            String raw = Text.of(CartPage.TOTAL)
                    .answeredBy(actor)
                    .replace("$", "")
                    .trim();

            return Double.parseDouble(raw);
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static CartTotal value() {
        return new CartTotal();
    }
}
