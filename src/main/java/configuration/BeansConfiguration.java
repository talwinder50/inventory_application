package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import profiles.Production;
import services.CriteraService;
import services.CriteraServiceImpl;

@Configuration
@Production
public class BeansConfiguration {
	
	@Bean
	public CriteraService greetingService() {
		return new CriteraServiceImpl();
	}
	

}
