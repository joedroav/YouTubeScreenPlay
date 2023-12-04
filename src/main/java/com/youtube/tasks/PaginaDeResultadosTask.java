package com.youtube.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Scroll;
import org.fluentlenium.core.annotation.Page;
import static com.youtube.tasks.RealizarBusquedaTask.textoBuscado;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import java.util.List;
import java.util.Random;

public class PaginaDeResultadosTask implements Task {
    private static final Target COINCIDENCIAS_XPATH = Target.the("Coincidencias XPath")
            .locatedBy("//yt-formatted-string[contains(text(), '"+ textoBuscado  +"')]");

    private static String xpathASeleccionar;
    @Override
    public <T extends Actor> void performAs(T actor) {
        // hago scroll para obtener todas las coincidencias
        actor.attemptsTo(Scroll.to(COINCIDENCIAS_XPATH));
        // Hago una espera hasta que todos los elementos estén visibles
        actor.attemptsTo(WaitUntil.the(COINCIDENCIAS_XPATH, isVisible()).forNoMoreThan(10).seconds());
        // Obtengo toda la lista de coincidencias de elementos aplicando WebElementFacade
        List<WebElementFacade> elementos = COINCIDENCIAS_XPATH.resolveAllFor(actor);
        int i=1;
        System.out.println("Elementos encontrados:"+elementos.size());
        // imprimo todos los elementos que encontré
        for (WebElementFacade elemento : elementos) {
            // recorre la lista de elementos encontrados y los imprime
            System.out.println(i + "." + elemento.getText());
            i++;
        }
        //depuro la lista

        //instancio la clase random para utilizarla
        Random random = new Random();
        //genero un numero aleatorio entre el 0 y el numero de coincidencias ya depuradas
        int numeroAleatorio=0;
        do {
            numeroAleatorio = random.nextInt(elementos.size());
        }while(numeroAleatorio==0);

        System.out.println("Número aleatorio entre 0 y las coincidencias resulto: " + numeroAleatorio);
        // con el numero aleatorio armo el xpath al que necesito darle click
        xpathASeleccionar =
                "(//yt-formatted-string[contains(text(), '"+ textoBuscado  +"')])["+ numeroAleatorio +"]";
        System.out.println(xpathASeleccionar);
        actor.attemptsTo(Click.on(xpathASeleccionar));
    }
    public static PaginaDeResultadosTask listarResultados() {
        return instrumented(PaginaDeResultadosTask.class);
    }
}
