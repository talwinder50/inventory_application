package services;


import model.SearchCriteria;

public interface CriteraService {

	//public SearchCriteria findDisplayName(SearchCriteria displayName);
   // public SearchCriteria saveSearchCriteria(SearchCriteria searchCriteria);
    public Iterable<SearchCriteria> findAll();
	
}
