package com.galactic_competition.controllers;

import com.galactic_competition.constants.CombatConstants;
import com.galactic_competition.entities.Combat;
import com.galactic_competition.models.CombatFightRequest;
import com.galactic_competition.models.RankingListResponse;
import com.galactic_competition.service.CombatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Combat", description = "Servicio para consultas asociadas a Combates")
@RestController
@RequestMapping("/combat")
public class CombatController {
    private static final Logger log = LogManager.getLogger(CombatController.class);

    @Autowired
    CombatService combatService;

    @Operation()
    @GetMapping(value = CombatConstants.GET_FIGHT_LIST_URI)
    @ResponseBody
    public List<Combat> list(){
        List<Combat> response = new ArrayList<>();
        try{
            response = combatService.list();

        }catch (Exception e){
            log.error("Error getSpeciesList");
        }
        return response;
    }

    @Operation(description = CombatConstants.FIGHT_DESCRIPTION)
    @PostMapping(value = CombatConstants.FIGHT_URI)
    @ResponseBody
    public String fight(@RequestBody CombatFightRequest combatFightRequest){
        String response = "";
        try{
            response = combatService.fight(combatFightRequest.getFighter1(),combatFightRequest.getFighter2());

        }catch (Exception e){
            log.error("Error getSpeciesList");
        }
        return response;
    }

    @Operation()
    @GetMapping(value = CombatConstants.GET_RANKING_URI)
    @ResponseBody
    public RankingListResponse ranking(){
        RankingListResponse response = new RankingListResponse();
        try{
            response = combatService.ranking();

        }catch (Exception e){
            log.error("Error ranking");
        }
        return response;
    }

}