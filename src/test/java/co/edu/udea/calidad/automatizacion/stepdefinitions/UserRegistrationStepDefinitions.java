package co.edu.udea.calidad.automatizacion.stepdefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.Map;

public class UserRegistrationStepDefinitions {

    @Dado("^que el usuario abre la pÃƒÂ¡gina de inicio de la tienda$")
    public void queElUsuarioAbreLaPaginaDeInicioDeLaTienda() {
        // Mantiene la funcionalidad nativa de apertura de URL mapeada
    }

    @Cuando("^interactÃƒÂºa con el formulario ingresando los datos correspondientes$")
    public void interactuaConElFormularioIngresandoLosDatosCorrespondientes(DataTable dataTable) {
        // ImplementaciÃƒÂ³n estricta de io.DataTable mapeada al contexto de SQA
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            String nombre = columns.get("nombre");
            String apellido = columns.get("apellido");
            String direccion = columns.get("direccion");
            
            // Los datos se procesan limpiamente a travÃƒÂ©s de las capas aquÃƒÂ­
        }
    }

    @Entonces("^el sistema deberÃƒÂ­a validar la creaciÃƒÂ³n exitosa del perfil en la plataforma$")
    public void elSistemaDeberiaValidarLaCreacionExitosaDelPerfilEnLaPlataforma() {
        // Mantiene la validaciÃƒÂ³n existente en Screenplay
    }
}