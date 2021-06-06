package team.nti.test.galaxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import team.nti.test.galaxy.model.Planet;

@Component
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
