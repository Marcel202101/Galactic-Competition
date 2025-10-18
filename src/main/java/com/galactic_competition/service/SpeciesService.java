package com.galactic_competition.service;

import com.galactic_competition.Repository.SpeciesRepository;
import com.galactic_competition.entities.Species;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SpeciesService {
    private static final Logger log = LogManager.getLogger(SpeciesService.class);

    private final SpeciesRepository speciesRepository;

    SpeciesService(SpeciesRepository speciesRepository){
        this.speciesRepository = speciesRepository;
    }

    public List<Species> getSpeciesList(){
        try{
            return this.speciesRepository.list();
        }catch (Exception e){
            log.error(String.format("Error getSpeciesList %s", e));
            return new ArrayList<>();
        }

    }
    public String addSpecies(Species specie) {
        try{
            if(!this.speciesRepository.findByName(specie.getName())){
                this.speciesRepository.add((specie));
                return "Registro Satisfactorio";
            }
        }catch (Exception e){
            log.error(String.format("Error addSpecies %s", e));
        }
        return "Registro Fallido";


    }
}