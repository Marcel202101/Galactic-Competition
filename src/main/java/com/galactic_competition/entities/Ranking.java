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
public class Ranking {
    @JsonProperty("position")
    private Integer position;

    @JsonProperty("name")
    private String name;

    @JsonProperty("wins")
    private Long wins;

}
