package team.nti.test.galaxy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import team.nti.test.galaxy.model.Lord;

@Component
public interface LordRepository extends JpaRepository<Lord,Long> {
}
