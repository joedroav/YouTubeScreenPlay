package com.youtube.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;

public class PaginaReproduccionUI implements Task {
    public static Target TXT_REPRODUCCION = Target.the("Titulo video")
            .locatedBy("//h1[@class='style-scope ytd-watch-metadata']");
    @Override
    public <T extends Actor> void performAs(T actor) {
    }
}
