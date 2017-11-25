package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.SearchCriteria;
import services.CriteraService;

@RestController
public class CriteraController {
	
	   @Autowired
	   CriteraService service;
	   
	   @RequestMapping("/searchCriteriaAll")       
        public Iterable<SearchCriteria> findAll()
        {       
        	return service.findAll();
        }  

 }
