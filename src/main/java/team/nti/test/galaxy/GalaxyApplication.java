package team.nti.test.galaxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("team.nti.test.galaxy.*")
@ComponentScan(basePackages = { "team.nti.test.galaxy.*" })
@EntityScan("team.nti.test.galaxy.*")
@SpringBootApplication
public class GalaxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalaxyApplication.class, args);
	}

}
