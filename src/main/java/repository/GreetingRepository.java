package repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import model.Greeting;

public interface GreetingRepository extends PagingAndSortingRepository<Greeting,String> {
	
	Greeting findByGender(String gender);
	
}
