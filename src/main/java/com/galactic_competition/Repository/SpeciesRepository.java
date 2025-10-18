package com.galactic_competition.Repository;

import com.galactic_competition.entities.Species;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SpeciesRepository {
    List<Species> list = new ArrayList<>();

     public List<Species> list(){
        return this.list;
    }

    public void add(Species specie){
         this.list.add(specie);
    }

    public boolean findByName(String name){ return this.list.stream().anyMatch(
            species -> species.getName().equals(name));}

    public Species getSpecieByName(String name){    return this.list.stream()
            .filter(specie -> specie.getName().equals(name))
            .findFirst()
            .orElse(null);
    }


}
