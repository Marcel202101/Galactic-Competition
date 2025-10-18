package com.galactic_competition.controllers;

import com.galactic_competition.constants.CombatConstants;
import com.galactic_competition.entities.Combat;
import com.galactic_competition.models.request.CombatFightRequest;
import com.galactic_competition.models.response.RankingListResponse;
import com.galactic_competition.service.CombatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Combat", description = "Servicio para consultas asociadas a Combates")
@RestController
@RequestMapping("/combat")
public class CombatController {
    @Autowired
    CombatService combatService;

    @Operation()
    @GetMapping(value = CombatConstants.GET_FIGHT_LIST_URI)
    @ResponseBody
    public List<Combat> list(){
        return combatService.list();
    }

    @Operation(description = CombatConstants.FIGHT_DESCRIPTION)
    @PostMapping(value = CombatConstants.FIGHT_URI)
    @ResponseBody
    public String fight(@Valid @RequestBody CombatFightRequest combatFightRequest){
        return  combatService.fight(combatFightRequest.getFighter1(),combatFightRequest.getFighter2());
    }

    @Operation()
    @GetMapping(value = CombatConstants.GET_RANKING_URI)
    @ResponseBody
    public RankingListResponse ranking(){
        return combatService.ranking();
    }

}