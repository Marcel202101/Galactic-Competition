package com.galactic_competition.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema()
public class Species {
    @JsonProperty("name")
    private String name;

    @JsonProperty("special")
    private String special;

    @JsonProperty("powerLevel")
    private Integer powerLevel;

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                ", special='" + special + '\'' +
                ", powerLevel=" + powerLevel +
                '}';
    }
}
