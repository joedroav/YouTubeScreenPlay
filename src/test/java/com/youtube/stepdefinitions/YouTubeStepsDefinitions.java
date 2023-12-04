package com.youtube.stepdefinitions;
import com.youtube.questions.ListarCoincidenciasQuestions;
import com.youtube.tasks.PaginaDeResultadosTask;
import com.youtube.tasks.PaginaInicialTask;
import com.youtube.tasks.RealizarBusquedaTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class YouTubeStepsDefinitions {
    @Before
    public void setupActor() {
        setTheStage(new OnlineCast());
    }

    @Dado("Que el usuario tiene acceso a la pagina de youtube")
    public void queElUsuarioTieneAccesoALaPaginaDeYoutube() {
        theActorCalled("Usuario").wasAbleTo(
                PaginaInicialTask.abrirNavegador()
        );
    }
    @Cuando("el usuario realiza la busqueda de un video")
    public void elUsuarioRealizaLaBusquedaDeUnVideo() {
        theActorInTheSpotlight().attemptsTo(
                RealizarBusquedaTask.buscarVideo(),
                PaginaDeResultadosTask.listarResultados()
        );
    }
    @Entonces("el sistema reproducira el video")
    public void elSistemaReproduciraElVideo() {
        theActorInTheSpotlight().should(
                seeThat(
                        ListarCoincidenciasQuestions.verificarReproduccion(),
                        Matchers.equalTo(true)
                )
        );
    }
}
