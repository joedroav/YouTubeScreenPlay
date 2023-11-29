package com.youtube.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.youtube.UI.BusquedaUI.TXT_BUSQUEDA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarBusquedaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue("Soda Estereo").into(TXT_BUSQUEDA).thenHit(Keys.ENTER)
        );
    }
        public static RealizarBusquedaTask buscarVideo(){
            return instrumented(RealizarBusquedaTask.class);}

}
