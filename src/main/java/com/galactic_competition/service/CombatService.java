package com.galactic_competition.service;

import com.galactic_competition.Repository.CombatRepository;
import com.galactic_competition.Repository.SpeciesRepository;
import com.galactic_competition.entities.Combat;
import com.galactic_competition.entities.Ranking;
import com.galactic_competition.entities.Species;
import com.galactic_competition.models.FightResult;
import com.galactic_competition.models.response.RankingListResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CombatService {
    private final SpeciesRepository speciesRepository;
    private final  CombatRepository combatRepository;

    CombatService(SpeciesRepository speciesRepository, CombatRepository combatRepository){
        this.speciesRepository = speciesRepository;
        this.combatRepository = combatRepository;
    }

    public FightResult fight(String fighter1Name, String fighter2Name) {
        FightResult winnerSpecie = new FightResult();

        Species specie1 = this.speciesRepository.getSpecieByName(fighter1Name);
        Species specie2 = this.speciesRepository.getSpecieByName(fighter2Name);
        if (specie1 == null) {
            winnerSpecie.setMessage( fighter1Name + " no está registrado en las especies");
            winnerSpecie.setHasError(Boolean.TRUE);
            return winnerSpecie;
        }
        if (specie2 == null) {
            winnerSpecie.setMessage( fighter2Name + " no está registrado en las especies");
            winnerSpecie.setHasError(Boolean.TRUE);
            return winnerSpecie;

        }
        if (fighter1Name.equalsIgnoreCase(fighter2Name)) {
            winnerSpecie.setMessage("No debe ser la misma especie");
            winnerSpecie.setHasError(Boolean.TRUE);
            return winnerSpecie;
        }

        if (specie1.getPowerLevel() > specie2.getPowerLevel()) {
            winnerSpecie.setWinner(specie1);
            winnerSpecie.setMessage(specie1.getName() + " gana con un powerLevel de " + specie1.getPowerLevel());
        } else if (specie2.getPowerLevel() > specie1.getPowerLevel()) {
            winnerSpecie.setWinner(specie2);
            winnerSpecie.setMessage(specie2.getName() + " gana con un powerLevel de " + specie2.getPowerLevel());
        } else {
            if (specie1.getName().compareToIgnoreCase(specie2.getName()) < 0) {
                winnerSpecie.setWinner(specie1);
            } else {
                winnerSpecie.setWinner(specie2);
            }
            winnerSpecie.setMessage(winnerSpecie.getWinner().getName() + " gana por orden alfabético");
        }
        this.combatRepository.add(specie1, specie2, winnerSpecie.getWinner().getName());
        return winnerSpecie;

    }

    public List<Combat> list() {
        return this.combatRepository.list();
    }

    public RankingListResponse ranking() {
        RankingListResponse response = new RankingListResponse();
        Map<String, Long> winsBySpecies = this.combatRepository.list().stream()
                .collect(Collectors.groupingBy(
                        Combat::getWinner,
                        Collectors.counting()
                ));

        this.speciesRepository.list()
                .forEach(s -> winsBySpecies.putIfAbsent(s.getName(), 0L));

        List<Ranking> rankingList = winsBySpecies.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(entry -> new Ranking(0, entry.getKey(), entry.getValue()))
                .toList();

        for (int i = 0; i < rankingList.size(); i++) {
            rankingList.get(i).setPosition(i + 1);
        }
        response.setRanking(rankingList);
        return response;
    }

    public Combat randomFight() {
        List<Species> speciesList = this.speciesRepository.list();
        if (speciesList.size() < 2) {
            throw new IllegalStateException("Se requieren al menos dos especies para combatir.");
        }
        Collections.shuffle(speciesList);
        Species species1 = speciesList.get(0);
        Species species2 = speciesList.get(1);

        FightResult winner = fight(species1.getName(), species2.getName());
        return new Combat(species1,species2,winner.getMessage());
    }
}