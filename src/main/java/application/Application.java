package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages ={"configuration","controller"})
//@EnableJpaRepositories(basePackages= {"repository"})
//@EntityScan("model")
public class Application {

    public static void main(String[] args) {
    	
        SpringApplication.run(Application.class, args);
        
    }
}
