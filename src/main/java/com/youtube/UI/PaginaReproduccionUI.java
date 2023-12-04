package com.youtube.UI;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaReproduccionUI {
    public static Target TXT_REPRODUCCION = Target.the("Titulo video")
            .locatedBy("//h1[@class='style-scope ytd-watch-metadata']");
}
