package com.youtube.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ListarCoincidenciasQuestions implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return null;
    }

    // El elemento que me trae los tags es
    // //*[@class="yt-simple-endpoint style-scope ytd-video-renderer"]
}
