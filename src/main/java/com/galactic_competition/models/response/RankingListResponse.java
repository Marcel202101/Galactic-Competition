package com.galactic_competition.models.response;

import com.galactic_competition.entities.Ranking;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema()
public class RankingListResponse {

    @Schema(description = "Ranking de victorias")
    private List<Ranking> ranking;

}
