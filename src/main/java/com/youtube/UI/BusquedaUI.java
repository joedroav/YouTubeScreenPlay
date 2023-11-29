package com.youtube.UI;

import net.serenitybdd.screenplay.targets.Target;

public class BusquedaUI {
    public static Target TXT_BUSQUEDA= Target.the("Campo busqueda")
            .locatedBy("//input[@id='search']");

}
