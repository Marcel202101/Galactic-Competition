package com.galactic_competition.service;

import com.galactic_competition.Repository.SpeciesRepository;
import com.galactic_competition.entities.Species;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;

    SpeciesService(SpeciesRepository speciesRepository){
        this.speciesRepository = speciesRepository;
    }

    public List<Species> getSpeciesList(){
        return this.speciesRepository.list();
    }
    public String addSpecies(Species specie) {
        if(!this.speciesRepository.findByName(specie.getName())){
            this.speciesRepository.add((specie));
            return "Registro Satisfactorio";
        }
        return "Registro Fallido";
    }
}