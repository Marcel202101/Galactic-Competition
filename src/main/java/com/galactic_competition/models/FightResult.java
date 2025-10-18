package com.galactic_competition.models;

import com.galactic_competition.entities.Species;
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
public class FightResult {
    private Species winner;
    private String message;
    private boolean hasError = Boolean.FALSE;

}