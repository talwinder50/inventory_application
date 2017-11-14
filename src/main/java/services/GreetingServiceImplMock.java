package services;

import org.springframework.stereotype.Service;

import model.Greeting;


@Service
public class GreetingServiceImplMock implements GreetingService {

	@Override
	public Greeting createNewGreeting(String name, String gender) {
		// TODO Auto-generated method stub
		return new Greeting(23,"This is mock result");
	}

}
