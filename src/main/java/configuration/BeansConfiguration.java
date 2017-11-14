package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import profiles.Production;
import services.GreetingService;
import services.GreetingServiceImpl;

@Configuration
@Production
public class BeansConfiguration {
	
	@Bean
	public GreetingService greetingService() {
		return new GreetingServiceImpl();
	}
	

}
