package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import profiles.Mock;
import services.CriteraService;
import services.CriteraServiceImplMock;

@Configuration
@Mock
public class BeansConfigurationMock {

	@Bean
	public CriteraService greetingService() {
		return new CriteraServiceImplMock();
	}
	
	
}
