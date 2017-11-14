package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import profiles.Mock;
import services.GreetingService;
import services.GreetingServiceImplMock;

@Configuration
@Mock
public class BeansConfigurationMock {

	@Bean
	public GreetingService greetingService() {
		return new GreetingServiceImplMock();
	}
	
	
}
