package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Greeting;
import services.GreetingService;

@RestController
public class GreetingController {

   /* private static final String template = "Waheguru ji ka khalsa waheguru ji ki fateh, %s";
   
    private final AtomicLong counter = new AtomicLong();*/

 
    
   /* @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
    		@RequestParam(value="gender", defaultValue="Oneness")String gender) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name)
      );
    }*/
	
	   @Autowired
	   GreetingService service;
	   
    @RequestMapping("/greeting")        
        public Greeting createNewGreeting(@RequestParam(value="name", defaultValue="World")String name,
        		@RequestParam(value="gender", defaultValue="Oneness")String gender)
        {       
        	return service.createNewGreeting(name, gender);     	
        }  
    
    
    
    }
