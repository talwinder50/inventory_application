package services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Greeting;
import repository.GreetingRepository;

@Service
public class GreetingServiceImpl implements GreetingService {
  
	@Autowired
	GreetingRepository repo;
	
	  private static final String template = "Waheguru ji ka khalsa waheguru ji ki fateh, %s";
	  private final AtomicLong counter = new AtomicLong();	
	
	public Greeting createNewGreeting(String name,String gender)
    {
    
	return repo.findByGender(gender);
		//return new Greeting(counter.incrementAndGet(), String.format(template, name),gender);
    }
    
	
}
