package team.nti.test.galaxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.nti.test.galaxy.model.Lord;
import team.nti.test.galaxy.model.Planet;
import team.nti.test.galaxy.repository.LordRepository;
import team.nti.test.galaxy.repository.PlanetRepository;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LordService {

    private final LordRepository lordRepository;
    private final PlanetRepository planetRepository;
    @Autowired
    public LordService(LordRepository lordRepository, PlanetRepository planetRepository) {
        this.lordRepository = lordRepository;
        this.planetRepository = planetRepository;
    }

    @PostConstruct
    public void init() {
        if (!lordRepository.existsById(1L)) {
            Lord nullLord = new Lord(0L, "Нет", 0);
            lordRepository.save(nullLord);
        }
    }


    public List<Lord> getAllLordsWithoutNull(){
        return lordRepository.findAll().stream().filter(lord->!lord.getId().equals(1L)).collect(Collectors.toList());
    }
    public List<Lord> getAllLords(){
        return lordRepository.findAll();
    }

    public List<Lord> getAllLazyLords(){
        return lordRepository.findAll().stream().filter(lord -> lord.getPlanetsList().isEmpty()).filter(lord->!lord.getId().equals(1L)).collect(Collectors.toList());
    }
    public List<Lord> getTenYoungest(){
        return lordRepository.findAll().stream().sorted(Comparator.comparing(Lord::getAge)).filter(lord->!lord.getId().equals(1L)).limit(10).collect(Collectors.toList());
    }
    public void add(Lord lord){
        lordRepository.save(lord);
    }
    public Lord getById(Long id){
        return lordRepository.getById(id);
    }

    public void remove(Lord lord){
        lordRepository.delete(lord);
        for (Planet planet : planetRepository.findAll()) {
            if (planet.getLord().getId().equals(lord.getId())) {
                planet.setLord(lordRepository.getById(1L));
                planetRepository.save(planet);
            }
        }
    }
}
