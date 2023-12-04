package com.youtube.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.youtube.UI.PaginaReproduccionUI.TXT_REPRODUCCION;

public class ListarCoincidenciasQuestions implements Question <Boolean>{

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade titulo = TXT_REPRODUCCION.resolveFor(actor);
        return titulo.isDisplayed();
    }
    public static Question<Boolean> verificarReproduccion(){
        return new ListarCoincidenciasQuestions();
    }
}
