package test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import model.SearchCriteria;
import repository.SearchCriteriaRepository;
import test.configuration.BeansConfigurationTest;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {BeansConfigurationTest.class})
@ActiveProfiles("production")
@TestPropertySource("file:/Users/harwinderkaur/Desktop/git_repos/Inventory/src/main/resources/application.properties")
public class SearchCriteriaRepositoryTest{
	
	@Autowired
	SearchCriteriaRepository repo;

	@Test
	public void saveSearchCriteriaTest1(){
		
		SearchCriteria searchCriteria = new SearchCriteria(1,"Waheguru");
		repo.save(searchCriteria);
		
	}
}
