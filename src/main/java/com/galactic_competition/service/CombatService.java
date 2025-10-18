package com.galactic_competition.service;

import com.galactic_competition.Repository.CombatRepository;
import com.galactic_competition.Repository.SpeciesRepository;
import com.galactic_competition.entities.Combat;
import com.galactic_competition.entities.Ranking;
import com.galactic_competition.entities.Species;
import com.galactic_competition.models.RankingListResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CombatService {
    private static final Logger log = LogManager.getLogger(CombatService.class);
    private final SpeciesRepository speciesRepository;
    private final  CombatRepository combatRepository;

    CombatService(SpeciesRepository speciesRepository, CombatRepository combatRepository){
        this.speciesRepository = speciesRepository;
        this.combatRepository = combatRepository;
    }

    public String fight(String fighter1Name, String fighter2Name) {
        Species winnerSpecie;
        String resultMessage;
        try{
            Species specie1 = this.speciesRepository.getSpecieByName(fighter1Name);
            Species specie2 = this.speciesRepository.getSpecieByName(fighter2Name);

            if (specie1 == null) {
                return fighter1Name + " no está registrado en las especies";
            }
            if (specie2 == null) {
                return fighter2Name + " no está registrado en las especies";
            }
            if (fighter1Name.equalsIgnoreCase(fighter2Name)) {
                return "No debe ser la misma especie";
            }

            if (specie1.getPowerLevel() > specie2.getPowerLevel()) {
                winnerSpecie = specie1;
                resultMessage = specie1.getName() + " gana con un powerLevel de " + specie1.getPowerLevel();
            } else if (specie2.getPowerLevel() > specie1.getPowerLevel()) {
                winnerSpecie = specie2;
                resultMessage = specie2.getName() + " gana con un powerLevel de " + specie2.getPowerLevel();
            } else {
                if (specie1.getName().compareToIgnoreCase(specie2.getName()) < 0) {
                    winnerSpecie = specie1;
                } else {
                    winnerSpecie = specie2;
                }
                resultMessage = winnerSpecie.getName() + " gana por orden alfabético";
            }
            this.combatRepository.add(specie1, specie2, winnerSpecie.getName());

        }catch (Exception e){
            resultMessage = "Fallo en Combate";
            log.error("Error fight" + e);
        }
        return resultMessage;

    }

    public List<Combat> list() {
        try{
            return this.combatRepository.list();
        }catch (Exception e){
            log.error("Error list" + e);
            return new ArrayList<>();
        }
    }

    public RankingListResponse ranking() {
        RankingListResponse response = new RankingListResponse();
        try{
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

        }catch (Exception e){
            log.error("Error ranking" + e);
            return response;
        }
    }
}