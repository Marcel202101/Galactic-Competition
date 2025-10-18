package com.galactic_competition.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema()
public class Species {
    @JsonProperty("name")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @JsonProperty("special")
    @NotBlank(message = "El special no puede estar vacío")

    private String special;

    @JsonProperty("powerLevel")
    @NotNull(message = "El nivel de poder es obligatorio")
    @Min(value = 1, message = "El nivel de poder debe ser al menos 1")
    @Max(value = 100, message = "El nivel de poder no puede superar 100")
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
