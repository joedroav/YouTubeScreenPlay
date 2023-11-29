package com.youtube.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaginaReproduccion implements Task {

    private static final Target txtReproduccion = Target.the("Reproduccion XPath")
            .locatedBy("//h1[@class='style-scope ytd-watch-metadata']");



    @Override
    public <T extends Actor> void performAs(T actor) {
    }

    public static PaginaReproduccion compararResultados() {
        return instrumented(PaginaReproduccion.class);
    }
}
