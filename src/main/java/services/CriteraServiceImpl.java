package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.SearchCriteria;
import repository.SearchCriteriaRepository;

@Service
public class CriteraServiceImpl implements CriteraService {
  
	@Autowired
	SearchCriteriaRepository repo;

	@Override
	public Iterable<SearchCriteria> findAll() {
		// TODO Auto-generated method stub
		Iterable<SearchCriteria> search = (Iterable<SearchCriteria>) repo.findAll();
		return search;
	}
	
}
