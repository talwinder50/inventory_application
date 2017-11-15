package services;


import model.SearchCriteria;

public interface CriteraService {

	public SearchCriteria findDisplayName(String displayName);
    public SearchCriteria saveSearchCriteria(SearchCriteria searchCriteria);
	
}
