package com.galactic_competition.Repository;

import com.galactic_competition.entities.Combat;
import com.galactic_competition.entities.Species;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CombatRepository {
    List<Combat> list = new ArrayList<>();

     public List<Combat> list(){
        return this.list;
    }

    public void add(Species specie1, Species specie2, String winner){
         Combat combat = new Combat(specie1,specie2,winner);
         this.list.add(combat);
    }



}
