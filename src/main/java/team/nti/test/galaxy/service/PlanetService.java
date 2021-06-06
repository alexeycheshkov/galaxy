package team.nti.test.galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.nti.test.galaxy.model.Planet;
import team.nti.test.galaxy.repository.PlanetRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    PlanetRepository planetRepository;
    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> getAllPlanets (){
        return planetRepository.findAll();
    }

    public List<Planet> getPlanetsByLordId (Long id){
        return planetRepository.findAll().stream().filter(planet -> planet.getLord().getId().equals(id)).collect(Collectors.toList());
    }

    public Planet getById(Long id){
        return planetRepository.getById(id);
    }


    public void add(Planet planet){
        planetRepository.save(planet);
    }

    public void remove(Planet planet){
        planetRepository.delete(planet);
    }
}
