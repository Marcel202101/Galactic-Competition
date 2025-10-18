package com.galactic_competition.controllers;

import com.galactic_competition.constants.SpeciesConstants;
import com.galactic_competition.entities.Species;
import com.galactic_competition.models.SpeciesListResponse;
import com.galactic_competition.service.SpeciesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Tag(name = "Species", description = "Servicio para consultas asociadas a Especies")
@RestController
@RequestMapping("/species")
public class SpeciesController {
    private static final Logger log = LogManager.getLogger(SpeciesController.class);

    @Autowired
    SpeciesService speciesService;

    @Operation()
    @GetMapping(value = SpeciesConstants.GET_SPECIES_URI)
    @ResponseBody
    public SpeciesListResponse getSpeciesList(){
        SpeciesListResponse response = new SpeciesListResponse();
        try{
            response.setSpecies(speciesService.getSpeciesList());

        }catch (Exception e){
            log.error("Error getSpeciesList");
        }
        return response;
    }

    @Operation(description = SpeciesConstants.ADD_SPECIES)
    @PostMapping(value = SpeciesConstants.ADD_SPECIES_URI)
    @ResponseBody
    public String addSpecies(@RequestBody Species request){
        String response = "Failure";
        try{
            response = speciesService.addSpecies(request);
        }catch (Exception e){
            log.error("Error AddSpecies");
        }
        return response;
    }

}