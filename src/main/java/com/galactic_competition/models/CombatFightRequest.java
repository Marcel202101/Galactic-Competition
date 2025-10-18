package com.galactic_competition.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Modelo para solicitar un combate entre dos especies")
public class CombatFightRequest {

    @Schema(description = "Nombre o especie del primer luchador")
    @JsonProperty("fighter1")
    private String fighter1;

    @Schema(description = "Nombre o especie del segundo luchador")
    @JsonProperty("fighter2")
    private String fighter2;

    @Override
    public String toString() {
        return "FightRequest{" +
                "fighter1=" + fighter1 +
                ", fighter2=" + fighter2 +
                '}';
    }
}
