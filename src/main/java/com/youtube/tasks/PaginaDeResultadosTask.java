package com.youtube.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Scroll;
import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import java.util.List;
import java.util.Random;

public class PaginaDeResultadosTask implements Task {

    private static final Target COINCIDENCIAS_XPATH = Target.the("Coincidencias XPath")
            .locatedBy("//*[@class='yt-simple-endpoint style-scope ytd-video-renderer']");
    private static String xpathASeleccionar;
    private static Target videoSeleccionado= Target.the("video seleccionado")
            .locatedBy(xpathASeleccionar);

    @Override
    public <T extends Actor> void performAs(T actor) {
        // hago scroll para obtener todas las coincidencias
        actor.attemptsTo(Scroll.to(COINCIDENCIAS_XPATH));

        // Hago una espera hasta que todos los elementos estén visibles
        actor.attemptsTo(WaitUntil.the(COINCIDENCIAS_XPATH, isVisible()).forNoMoreThan(10).seconds());

        // Obtengo toda la lista de coincidencias de elementos aplicando WebElementFacade
        List<WebElementFacade> elementos = COINCIDENCIAS_XPATH.resolveAllFor(actor);
        int i=1;

        // imprimo todos los elementos que encontré
        for (WebElementFacade elemento : elementos) {
            System.out.println(i+"."+elemento.getText());
            i++;
        }
        System.out.println(elementos.size());
        Random random = new Random();
        //genero un numero aleatorio entre el 0 y el numero de coincidencias encontradas
        int numeroAleatorio=0;
        do {
            numeroAleatorio = random.nextInt(elementos.size());
        }while(numeroAleatorio==0);


        System.out.println("Número aleatorio entre 0 y las coincidencias: " + numeroAleatorio);
        // con el numero aleatorio armo el xpath al que necesito darle click
        xpathASeleccionar = "(//*[@class='yt-simple-endpoint style-scope ytd-video-renderer'])"+"["+numeroAleatorio+"]";
        System.out.println(xpathASeleccionar);
        actor.attemptsTo(Click.on(xpathASeleccionar));
    }
    public static PaginaDeResultadosTask listarResultados() {
        return instrumented(PaginaDeResultadosTask.class);
    }

    public static Target getVideoSeleccionado() {
        return videoSeleccionado;
    }
}
