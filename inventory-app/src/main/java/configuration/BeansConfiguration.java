package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import profiles.Production;
import services.CriteraService;
import services.CriteraServiceImpl;
import services.ServerService;
import services.ServerInfoImpl;

@Configuration
@Production
public class BeansConfiguration {
	
	@Bean
	public CriteraService criteraService() {
		return new CriteraServiceImpl();
	}
	
	@Bean
	public ServerService serverInfo() {
		return new ServerInfoImpl();
	}
	

}
