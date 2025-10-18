package com.galactic_competition.controllers;

import com.galactic_competition.constants.SpeciesConstants;
import com.galactic_competition.entities.Species;
import com.galactic_competition.models.response.SpeciesListResponse;
import com.galactic_competition.service.SpeciesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Species", description = "Servicio para consultas asociadas a Especies")
@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    SpeciesService speciesService;

    @Operation()
    @GetMapping(value = SpeciesConstants.GET_SPECIES_URI)
    @ResponseBody
    public SpeciesListResponse getSpeciesList(){
        SpeciesListResponse response = new SpeciesListResponse();
        response.setSpecies(speciesService.getSpeciesList());
        return response;
    }

    @Operation(description = SpeciesConstants.ADD_SPECIES)
    @PostMapping(value = SpeciesConstants.ADD_SPECIES_URI)
    @ResponseBody
    public ResponseEntity<String> addSpecies(@Valid @RequestBody Species request){
        return ResponseEntity.ok(speciesService.addSpecies(request));
    }

}