package com.galactic_competition.constants;
public class SpeciesConstants {
    private SpeciesConstants(){}
    public static final String HTML_PRE_IN = "<pre>{<br />";
    public static final String HTML_PRE_CLOSE = "}</pre>";
    public static final String HTML_EJEMPLO = "<u>Ejemplo:</u>";
    public static final String HTML_PARAMS_FINAL = "En caso de enviar los parámetros correctamente, deberá recibir un json de respuesta.</div>";

    public static final String HTML_UL_IN = "<ul class='list-group'> ";
    public static final String HTML_UL_CLOSE = "</ul>";

    public static final String HTML_LI_NAME_INFO = "<li class='list-group-item-warning'><b><u>name:</u></b> Monkey. </li>";
    public static final String HTML_LI_POWER_LEVEL = "<li class='list-group-item-warning'><b><u>powerLevel:</u></b> 15. </li>";
    public static final String HTML_LI_SPECIAL = "<li class='list-group-item-warning'><b><u>special:</u></b> DROP BANANAS. </li>";
    public static final String NAME_EXAMPLE="    \"<b>name</b>\" : <em>\"Monkey\"</em>,<br />";
    public static final String POWER_LEVEL_EXAMPLE="    \"<b>powerLevel</b>\" : <em>\"15\"</em>,<br />";
    public static final String SPECIAL_EXAMPLE="    \"<b>special</b>\" : <em>\"DROP BANANAS\"</em><br />";
    public static final String HTML_PARAMETERS_INFO="Recibe un JSON con los siguientes parámetros:";
    public static final String GET_SPECIES_URI= "/getSpeciesList";

    public static final String ADD_SPECIES_URI= "/addSpecies";

    public static final String ADD_SPECIES = "<div class='alert alert-info'><h3><u><span class='label label-default'> Servicio que obtiene las especies</span></u></h3>"
            + HTML_PARAMETERS_INFO
            + HTML_UL_IN
            + HTML_LI_NAME_INFO
            + HTML_LI_POWER_LEVEL
            + HTML_LI_SPECIAL
            + HTML_UL_CLOSE
            + HTML_EJEMPLO
            + HTML_PRE_IN
            + NAME_EXAMPLE
            + POWER_LEVEL_EXAMPLE
            + SPECIAL_EXAMPLE
            + HTML_PRE_CLOSE
            + HTML_PARAMS_FINAL;


}