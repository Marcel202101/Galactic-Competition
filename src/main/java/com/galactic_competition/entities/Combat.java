package com.galactic_competition.entities;

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
@Schema()
public class Combat {
    @JsonProperty("fighter1")
    private Species fighter1;

    @JsonProperty("fighter2")
    private Species fighter2;

    @JsonProperty("winner")
    private String winner;


}
