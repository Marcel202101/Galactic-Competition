package com.galactic_competition.constants;

public class CombatConstants {
    private CombatConstants(){}

    public static final String HTML_PRE_IN = "<pre>{<br />";
    public static final String HTML_PRE_CLOSE = "}</pre>";
    public static final String HTML_EJEMPLO = "<u>Ejemplo:</u>";
    public static final String HTML_PARAMS_FINAL = "En caso de enviar los parámetros correctamente, deberá recibir un JSON de respuesta.</div>";

    public static final String HTML_UL_IN = "<ul class='list-group'> ";
    public static final String HTML_UL_CLOSE = "</ul>";

    public static final String HTML_LI_FIGHTER1 = "<li class='list-group-item-warning'><b><u>fighter1:</u></b> Monkey.</li>";
    public static final String HTML_LI_FIGHTER2 = "<li class='list-group-item-warning'><b><u>fighter2:</u></b> Dragon.</li>";

    public static final String HTML_PARAMETERS_INFO = "Recibe un JSON con los siguientes parámetros:";

    public static final String FIGHT_JSON_EXAMPLE =
            "    \"<b>fighter1</b>\": <em>\"Monkey\"</em>,<br />" +
                    "    \"<b>fighter2</b>\": <em>\"Dragon\"</em><br />";


    public static final String GET_FIGHT_LIST_URI = "/getFightList";
    public static final String GET_RANKING_URI = "/ranking";
    public static final String GET_RANDOM_FIGHT_URI = "/randomFight";

    public static final String FIGHT_URI = "/fight";

    public static final String FIGHT_DESCRIPTION =
            "<div class='alert alert-info'><h3><u><span class='label label-default'>Servicio que realiza un combate entre dos especies</span></u></h3>"
                    + HTML_PARAMETERS_INFO
                    + HTML_UL_IN
                    + HTML_LI_FIGHTER1
                    + HTML_LI_FIGHTER2
                    + HTML_UL_CLOSE
                    + HTML_EJEMPLO
                    + HTML_PRE_IN
                    + FIGHT_JSON_EXAMPLE
                    + HTML_PRE_CLOSE
                    + HTML_PARAMS_FINAL;
}
