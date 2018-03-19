package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages ={"configuration","controller","services"})
@EnableJpaRepositories(basePackages= {"repository"})
@EntityScan("model")
@EnableAsync
@EnableScheduling
@EnableCaching
public class Application {
	// TODO: Move this class outside the package then you dont need to define the scanbase package.
    // @Responsestatuscode to result own exceptions 
    public static void main(String[] args) {
    	
        SpringApplication.run(Application.class, args);
        
    }
}
